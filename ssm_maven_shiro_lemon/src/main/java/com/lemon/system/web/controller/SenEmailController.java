package com.lemon.system.web.controller;

import com.lemon.pojo.TUsers;
import com.lemon.system.service.TUserService;
import com.lemon.system.service.impl.MailTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 邮箱注册
 */
@RestController
@RequestMapping("/email")
public class SenEmailController {


    @Autowired
    private TUserService tUserService;

    @Autowired
    private JavaMailSender javaMailSender;

    @Value ("${mail.smtp.username}")
    private String emailFrom;

    @Value ("${mail.smtp.username}")
    private String toEmail;


    @RequestMapping(value = "/send",method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public String senMsg( TUsers users , Model model ){
        System.out.println (users);
        MailTask mailTask=new MailTask (users.getInitPassword (),users.getEmail (),users.getUsername (),javaMailSender,1);
        Thread thread=new Thread ( mailTask );
        tUserService.addUser (users);
        thread.start ();
        return "发送邮件成功,请查收";
    }

    @RequestMapping(value = "/updateStatus/{email}/{initPassword}",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    @ResponseBody
    public String updateStatus( @PathVariable String email, @PathVariable String initPassword){
        System.out.println (email+initPassword);
        tUserService.updateActivate (email,initPassword);
        return "激活成功,可以通过账号或邮箱登陆登陆了,如需修改权限请联系管理员修改即可";
    }


  /*  @RequestMapping("send")
    @ResponseBody
    public Object senMsg(){
        SimpleMailMessage message = new SimpleMailMessage();
        //发件人的邮箱地址
        message.setFrom(emailFrom);
        //收件人的邮箱地址
        message.setTo("2385382591@qq.com");
        //邮件主题
        message.setSubject("spring email test!!!!");
        //邮件内容
        message.setText("收到的邮件内容：spring email test ！！！");
        //发送邮件
        javaMailSender.send(message);
        return message;
    }*/
}
