package com.lemon.system.service.impl;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import javax.mail.internet.MimeMessage;

/**
 * 向注册者发链接邮箱，修改用户认证字段为true及update密码
 * 实现Runnable开始多线程run()
 */
public class MailTask implements Runnable {

    private String initPassword; //初始化密码
    private String email; //用户邮箱
    private String username; //用户邮箱
    private JavaMailSender javaMailSender;//邮箱工具类
    private int operation;//状态

    public MailTask( String initPassword, String email, JavaMailSender javaMailSender, int operation ) {
        this.initPassword = initPassword;
        this.email = email;
        this.javaMailSender = javaMailSender;
        this.operation = operation;
    }

    public MailTask( String initPassword, String email, String username, JavaMailSender javaMailSender, int operation ) {
        this.initPassword = initPassword;
        this.email = email;
        this.username = username;
        this.javaMailSender = javaMailSender;
        this.operation = operation;
    }

    @Override
    public void run() {
        javaMailSender.send(new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                System.out.println("开始发邮件...");
                //构造邮件
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true,"UTF-8");
                mimeMessageHelper.setFrom("2385382591@qq.com");
                mimeMessageHelper.setTo(email);
                mimeMessageHelper.setSubject("一封激活邮件");
                StringBuilder sb  = new StringBuilder();
                sb.append("<html><head></head><body>");

                if(operation==1){
                    sb.append ("<span>您好,请点击下方链接进行注册</span></br>");
                    sb.append("<a href="+"http://localhost:8080/email/updateStatus"+"/");
                    sb.append(email);
                    sb.append ( "/");
                    sb.append ( initPassword);
                    sb.append(">点击激活</a></body>");
                }else{
                    sb.append("是否将您的密码修改为:");
                    sb.append(initPassword.substring(0,8));
                    sb.append("，<a href="+"2385382591@qq.com"+"verify?code="+initPassword+">");
                    sb.append("点击是</a></body>");
                }

                mimeMessageHelper.setText(sb.toString(),true);

                System.out.println("结束发邮件...");
            }
        });
    }
}








