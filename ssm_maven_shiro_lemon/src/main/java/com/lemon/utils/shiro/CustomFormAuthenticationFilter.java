package com.lemon.utils.shiro;

import com.lemon.pojo.TUsers;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登陆成功将用户保存到session中
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {


    @Override
    protected boolean onLoginSuccess( AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response ) throws Exception {
        System.out.println ("保存用户信息到session中");
        TUsers user = (TUsers) subject.getPrincipal ();
        HttpServletRequest httpServletRequest = WebUtils.toHttp ( request );
        HttpSession session = httpServletRequest.getSession ();
        session.setAttribute ( "user",user );
        return super.onLoginSuccess ( token, subject, request, response );
    }
}
