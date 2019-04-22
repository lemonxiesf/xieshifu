package com.lemon.finance.web.controller;

import com.github.pagehelper.PageInfo;
import com.lemon.expense.service.TAuditRecordService;
import com.lemon.expense.service.TExpenseService;
import com.lemon.finance.service.TSalaryRecordService;
import com.lemon.pojo.*;
import com.lemon.system.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/finance/")
public class FinanceController {

    @Autowired
    private TExpenseService tExpenseService;

    @Autowired
    private TAuditRecordService tAuditRecordService;

    @Autowired
    private TUserService tUserService;

    @Autowired
    private TSalaryRecordService tSalaryRecordService;

    /*
     * 报销单列表
     */
    @GetMapping("financeList")
    public String financeList( PoExpense poExpense, Model model ) {
        PageInfo<TExpense> expenseList = tExpenseService.financeAudit ( poExpense );
        model.addAttribute ( "expenseList", expenseList );
        return "finance/financeAudit/financeaudit_list";
    }

    /*
     * 财务审核报销单
     */
    @GetMapping("financeAudit/{expenseid}")
    public String financeAudit( @PathVariable Integer expenseid, Model model ) {
        List<TExpenseDetail> detailList = tExpenseService.findExpenseDetailByExpenseId ( expenseid );
        TExpense expense = tExpenseService.selectByPrimaryKey ( expenseid );
        List<TAuditRecord> auditList = tAuditRecordService.findAuditRecordByExpenseId ( expenseid );
        model.addAttribute ( "detailList", detailList );
        model.addAttribute ( "expense", expense );
        model.addAttribute ( "auditList", auditList );
        return "finance/financeAudit/financeaudit_audit";
    }

    /*
     * 审批
     */
    @PostMapping("endFinanceAudit")
    public String endFinanceAudit( TAuditRecord record, Integer expenseid, Model model ) {
        int count = this.tExpenseService.updateByPrimaryKey ( record.getAuditstate (), expenseid, record );
        List<TExpenseDetail> detailList = tExpenseService.findExpenseDetailByExpenseId ( expenseid );
        TExpense expense = tExpenseService.selectByPrimaryKey ( expenseid );
        List<TAuditRecord> auditList = tAuditRecordService.findAuditRecordByExpenseId ( expenseid );
        model.addAttribute ( "detailList", detailList );
        model.addAttribute ( "expense", expense );
        model.addAttribute ( "auditList", auditList );
        if (count > 0) {
            model.addAttribute ( "tip", "审批成功" );
        } else {
            model.addAttribute ( "tip", "审批失败" );
        }

        model.addAttribute ( "tip" );
        return "finance/financeAudit/financeaudit_audit";
    }

    /*
     * 薪资发放
     */
    @GetMapping("salaryPay")
    public String salaryPay( Model model ) {
        return "finance/salary/salarypayment_add";
    }

    /*
     * 查询薪资
     */
    @GetMapping("salaryQueryList")
    public String salaryQueryList( Model model, String username, String salarymonth ) {
        PageInfo<TSalaryRecord> salaryList = tSalaryRecordService.selectAll ( username ,salarymonth);
        model.addAttribute ( "salaryList", salaryList );
        return "finance/salary/salarypayment_list";
    }


}
