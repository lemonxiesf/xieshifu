package com.lemon.finance.web.controller;

import com.lemon.finance.service.TSalaryRecordService;
import com.lemon.pojo.TSalaryRecord;
import com.lemon.pojo.TUsers;
import com.lemon.system.service.TUserService;
import com.lemon.utils.dateUtils.CustomDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/salary/")
public class SalaryController {

    @Autowired
    private TUserService tUserService;

    @Autowired
    private TSalaryRecordService tSalaryRecordService;

    @PostMapping("selectNotIssue")
    public @ResponseBody List<TUsers> selectNotI(String salaryMonth){
        List<TUsers> userList = tUserService.selectNotIssue ( salaryMonth );
        return userList;
    }

    /*
     * 跟据id薪资
     */
    @PostMapping("querySalary")
    public @ResponseBody TUsers querySalary(int userid){
        TUsers user = tUserService.selectByPrimaryKey ( userid );
        return user;
    }

    /*
     *  薪资发放
     */
    @PostMapping("addSalary")
    public String addSalary( TSalaryRecord salaryRecord ,Model model){

        int count = tSalaryRecordService.insert ( salaryRecord );
        String username = this.tUserService.selectByPrimaryKey ( salaryRecord.getUserid () ).getUsername ();
        List<TUsers> userList = this.tUserService.selectAll ();
        model.addAttribute ( "userList", userList );
        if (count > 0){
            model.addAttribute ( "tip",username+ ""+CustomDateFormat.dateFormat (salaryRecord.getSalarymonth (),"yyyy-MM")+"月份的薪资发放成功" );
        }else{
            model.addAttribute ( "tip",username+ ""+CustomDateFormat.dateFormat (salaryRecord.getSalarymonth (),"yyyy-MM")+"月份的发放失败" );
        }
        return "finance/salary/salarypayment_add";
    }




}
