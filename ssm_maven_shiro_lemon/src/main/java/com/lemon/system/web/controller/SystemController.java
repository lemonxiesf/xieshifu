package com.lemon.system.web.controller;

import com.github.pagehelper.PageInfo;
import com.lemon.finance.service.TSalaryRecordService;
import com.lemon.pojo.TCost;
import com.lemon.pojo.TSalaryRecord;
import com.lemon.pojo.TUsers;
import com.lemon.system.service.TCostService;
import com.lemon.system.service.TUserService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/system/")
public class SystemController {

    @Autowired
    private TUserService tUserService;

    @Autowired
    private TCostService tCostService;

    @Autowired
    private TSalaryRecordService TSalaryRecordService;

    @GetMapping("userQuery")
    @RequiresRoles( "admin" )
    public String userQuery( TUsers user,Model model){
        System.out.println (user);
        PageInfo<TUsers> userList = tUserService.findUserByUserIdOrUserName ( user );
        model.addAttribute ( "userList",userList );
        model.addAttribute ( "user" ,user);
        return "system/user/userinfo_list";
    }
    @GetMapping("costQuery")
    @RequiresRoles( "finance" )
    public String findCostByCostIdOrCostName( TCost cost, Model model ) {
        PageInfo<TCost> costList = tCostService.findCostByCostIdOrCostName ( cost );
        model.addAttribute ( "costList", costList );
        return "system/cost/cost_list";
    }
    @GetMapping("myUserInfo")
    public String myUserInfo(HttpServletRequest request) {
        HttpSession session = request.getSession ();
        TUsers user = (TUsers)session.getAttribute ( "userInfo" );
        System.out.println (user.toString ());
        request.setAttribute ( "user",user );
        return "system/user/userinfo_show";
    }
    @GetMapping("mySalary")
    public String mySalary(HttpServletRequest request){
        HttpSession session = request.getSession ();
        TUsers user = (TUsers) session.getAttribute ( "userInfo" );
        PageInfo<TSalaryRecord> salaryList = TSalaryRecordService.findByUserId ( user.getUserid () );
        request.setAttribute ( "salaryList",salaryList );
        return "system/user/salarypayment_mylist";
    }





}
