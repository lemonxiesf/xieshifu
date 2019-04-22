package com.lemon.expense.web.controller;

import com.github.pagehelper.PageInfo;
import com.lemon.expense.service.TAuditRecordService;
import com.lemon.expense.service.TExpenseDetailService;
import com.lemon.expense.service.TExpenseService;
import com.lemon.pojo.*;
import com.lemon.system.service.TCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;


@Controller
@RequestMapping("/expense/")
public class ExpenseManageController {

    @Autowired
    private TExpenseService tExpenseService;

    @Autowired
    private TCostService tCostService;

    @Autowired
    private TExpenseDetailService tExpenseDetailService;

    @Autowired
    private TAuditRecordService tAuditRecordService;

    @GetMapping("addExpense")
    public String addExpense(Model model){
        List<TCost> costList = tCostService.selectAll ();
        model.addAttribute ( "costList",costList );
        return "expense/expense/expense_add";
    }



    @PostMapping("addExpense")
    public String addExpense( Model model, @RequestParam("file") MultipartFile file, TExpense expense, ExpenseDetailVo expenseDetailVo ){
//        System.out.println ( file );
        UUID uuid=UUID.randomUUID ();
        try {
            file.transferTo ( new File ("F:/exception/"+uuid+".jpg"));
        } catch (IOException e) {
            e.printStackTrace ();
        }

        List<TExpenseDetail> detailList=new ArrayList<> ();
        String[] costid = expenseDetailVo.getCostid ();
        String[] detailmoney = expenseDetailVo.getDetailmoney ();
        String[] detaildesc = expenseDetailVo.getDetaildesc ();

        for (int i=0;i<costid.length;i++){
            TExpenseDetail tExpenseDetail=new TExpenseDetail ();
            tExpenseDetail.setCostid (Integer.parseInt (costid[i]));
            tExpenseDetail.setDetailmoney (Float.parseFloat ( detailmoney[i] ));
            tExpenseDetail.setDetaildesc ( detaildesc[i] );
            detailList.add ( tExpenseDetail );
        }
        //添加报销单
        expense.setImagePath (uuid+".jpg");
        System.err.println ( expense.toString () );

        tExpenseService.insert (expense);

        int count = tExpenseDetailService.insert ( detailList);
        List<TCost> costList = tCostService.selectAll ();
        model.addAttribute ( "costList",costList );
        model.addAttribute ( "expense" ,expense);
        if (count > 0){
            model.addAttribute ( "tip" ,"提交报销单成功");
        }else{
            model.addAttribute ( "tip" ,"提交报销单失败");
        }

        return "expense/expense/expense_add";
    }

    @GetMapping("expenseQuery")
    private String expenseQuery( Model model, PoExpense poExpense ){
        PageInfo<TExpense> expenseList = tExpenseService.expenseCondition (poExpense);
        model.addAttribute ( "expenseList",expenseList );
        model.addAttribute ( "poExpense",poExpense );
        return "expense/expense/expense_list";
    }

    /*
     *报销单列表
     */
    @GetMapping("managerAudit")
    private String managerAudit(Model model,PoExpense poExpense){
        PageInfo<TExpense> expenseList = tExpenseService.managerAudit ( poExpense );
        model.addAttribute ( "expenseList",expenseList );
        return "expense/managerAudit/expense_managerlist";
    }

    /*
     * 查看报销单详情
     */
    @GetMapping("expenseDetails/{expenseid}")
    private String expenseDetails(Model model,@PathVariable Integer expenseid){
        List<TExpenseDetail> detailList= tExpenseService.findExpenseDetailByExpenseId ( expenseid );
        TExpense tExpense = tExpenseService.selectByPrimaryKey ( expenseid );
        List<TAuditRecord> auditList = tAuditRecordService.findAuditRecordByExpenseId ( expenseid );
        model.addAttribute ( "expense", tExpense);
        model.addAttribute ( "auditList", auditList);
        model.addAttribute ( "detailList", detailList);
        return "expense/expense/expense_show";
    }

    /*
     * 跳转到经理审批页面
     */
    @GetMapping("beginManagerAudit/{expenseid}")
    private String beginManagerAudit(Model model,@PathVariable Integer expenseid){
        List<TExpenseDetail> detailList= tExpenseService.findExpenseDetailByExpenseId ( expenseid );
        TExpense tExpense = tExpenseService.selectByPrimaryKey ( expenseid );


        model.addAttribute ( "expense", tExpense);
        model.addAttribute ( "detailList", detailList);
        return "expense/managerAudit/expense_audit";
    }

    /*
     * 经理审批结束
     */
    @PostMapping("endManagerAudit")
    private String endManagerAudit(Model model,TAuditRecord audit,TExpense expense){
        int count = tExpenseService.updateByPrimaryKey ( audit.getAuditstate (), audit.getExpenseid (), audit );
        List<TExpenseDetail> detailList = tExpenseService.findExpenseDetailByExpenseId ( expense.getExpenseid () );
        TExpense tExpense = tExpenseService.selectByPrimaryKey ( expense.getExpenseid () );
        model.addAttribute ( "audit" ,audit);
        model.addAttribute ("expense",tExpense);
        model.addAttribute ( "detailList", detailList);
        if (count > 0){
            model.addAttribute ( "tip","审批成功" );
        }else{
            model.addAttribute ( "tip","审批失败" );
        }

        return "expense/managerAudit/expense_audit";
    }

    /*
     *查看我的报销单
     */
    @GetMapping("myExpenseQuery")
    private String myExpenseQuery( Model model, HttpServletRequest request ){
        HttpSession session = request.getSession ();
        TUsers user = (TUsers)session.getAttribute ( "userInfo" );
        PageInfo<TExpense> expenseList=tExpenseService.findExpenseByUserId ( user.getUserid () );
        model.addAttribute ( "expenseList" ,expenseList);

        return "expense/expense/expense_mylist";
    }





}
