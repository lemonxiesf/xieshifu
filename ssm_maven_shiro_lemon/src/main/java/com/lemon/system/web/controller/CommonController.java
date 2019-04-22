package com.lemon.system.web.controller;

import com.github.pagehelper.PageInfo;
import com.lemon.finance.service.TSalaryRecordService;
import com.lemon.pojo.TMenu;
import com.lemon.pojo.TSalaryRecord;
import com.lemon.pojo.TUsers;
import com.lemon.system.service.TMenuService;
import com.lemon.system.service.TUserService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private TUserService tUserService;

    @Autowired
    private TMenuService tMenuService;

    @Autowired
    private TSalaryRecordService tSalaryRecordService;

    @GetMapping("/login")
    public String login() {
       return "login";
    }

     @PostMapping("/login")
    public String login( HttpServletRequest request ,Model model) {
        String shiroLoginFailure = (String) request.getAttribute ( "shiroLoginFailure" );
        System.out.println (shiroLoginFailure);
        //重复登陆
        if (StringUtils.isBlank ( shiroLoginFailure )){
            return this.index (model,request);
        }

        if (StringUtils.isNotBlank (shiroLoginFailure)) {
            System.out.println (UnknownAccountException.class.getName ());
            if (UnknownAccountException.class.getName ().equals (shiroLoginFailure)) {
                System.out.println ( "账号不存在" );
                model.addAttribute ( "tip","账号不存在" );
            }
            if (IncorrectCredentialsException.class.getName ().equals (shiroLoginFailure)) {
                System.out.println ( "用户名或密码错误" );
                model.addAttribute ( "tip","用户名或密码错误" );
            }
        }
        return "login";
    }

    @RequestMapping("/index")
    public String index(Model model,HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        TUsers user= (TUsers) subject.getPrincipal ();
        List<TMenu> menus = tMenuService.queryMenusByRoleId ( user.getRoleid () );
        model.addAttribute ("menus",menus);
        request.getSession ().setAttribute ( "userInfo" ,user);
        return "index";
    }

    @GetMapping("/console")
    public String console(HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession ();
        TUsers user = (TUsers) session.getAttribute ( "userInfo" );
        PageInfo<TSalaryRecord> salaryList = tSalaryRecordService.findByUserId ( user.getUserid () );
        httpServletRequest.setAttribute ( "salaryList",salaryList );
        return "main";
    }


}
