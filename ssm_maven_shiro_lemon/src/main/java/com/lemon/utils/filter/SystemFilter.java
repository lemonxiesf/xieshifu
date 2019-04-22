package com.lemon.utils.filter;

import com.lemon.pojo.TUsers;
import org.apache.shiro.SecurityUtils;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class SystemFilter implements Filter {


    @Override
    public void init( FilterConfig filterConfig ) throws ServletException {

    }

    @Override
    public void doFilter( ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain ) throws IOException, ServletException {
        System.out.println ("jing");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession ();
        TUsers tUsers = (TUsers) session.getAttribute ( "userInfo" );
        String path = request.getRequestURI ();

        if (path.contains ( "login" )) {
            filterChain.doFilter ( servletRequest, servletResponse );
        }else if (path.contains ( "index" )) {
            filterChain.doFilter ( servletRequest, servletResponse );
        }
        if (tUsers == null) {
            request.getRequestDispatcher ( "/common/renvate" ).forward ( request, servletResponse );
        }
    }

    @Override
    public void destroy() {

    }
}
