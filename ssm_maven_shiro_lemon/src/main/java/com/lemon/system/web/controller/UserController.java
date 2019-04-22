package com.lemon.system.web.controller;

import com.github.pagehelper.PageInfo;
import com.lemon.pojo.Result;
import com.lemon.pojo.TUsers;
import com.lemon.system.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("SpringMVCViewInspection")
@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private TUserService tUserService;

    @PostMapping("deleteUser")
    public String deleteUser(Integer [] ids){
       tUserService.deleteMultiUser ( ids );
        return "redirect:/system/userQuery";
    }

    @GetMapping("updateUser/{userid}")
    public String updateUser( @PathVariable Integer userid,Model model){
        TUsers user = tUserService.selectByPrimaryKey ( userid );
        model.addAttribute ( "user",user );
        return "system/user/userinfo_update";
    }
    @GetMapping("myUpdate/{userid}")
    public String myUpdate(@PathVariable Integer userid,Model model){
        TUsers user = tUserService.selectByPrimaryKey ( userid );
        model.addAttribute ( "user",user );
        return "system/user/userinfo_update";
    }

    @GetMapping("updateUser")
    public String updateUser(TUsers user,Model model){
        boolean flag = tUserService.updateUser ( user );
        if (flag){
            TUsers u = tUserService.selectByPrimaryKey ( user.getUserid () );
            model.addAttribute ( "tip","修改用户成功" );
            model.addAttribute ( "user" ,u);
        }else{
            model.addAttribute ( "tip","修改用户失败" );
        }
        return "system/user/userinfo_update";
    }



    @GetMapping("addUser")
    public String addUser(){
        return "system/user/userinfo_add";
    }

    @PostMapping("addUser")
    public String addUser( TUsers user , Model model ){
        int insert = tUserService.insert ( user );
        model.addAttribute ( "user",user );
        if (insert>0){
            model.addAttribute ( "tip","添加用户成功" );
        }else{
            model.addAttribute ( "tip","添加用户失败" );
        }

        return "system/user/userinfo_add";
    }

    @PostMapping("validateUser")
    @ResponseBody
    public Result addUser( String account ){
        Result result=new Result (  );
        TUsers byAccount = tUserService.findByAccount ( account );
        if (byAccount == null ){
            result.setSuccess ( true );
            result.setMassage ( "该账号可以使用" );
        }else{
            result.setSuccess ( false );
            result.setMassage ( "该账号已被占用" );
        }
        return result;
    }






}
