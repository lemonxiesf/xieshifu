package com.lemon.utils.interceptor;

import com.lemon.pojo.TUsers;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * 未登录拦截器
 */

public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle( HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o ) throws Exception {
        System.out.println ( "进来拦截器了" );
        HandlerMethod handlerMethod = (HandlerMethod) o;
        Method method = handlerMethod.getMethod ();
        String methodName = method.getName ();

        //登陆页面不拦截
        if ("login".equals ( methodName )) {
            return true;
            //登陆的时候不拦截
        } else if ("index".equals ( methodName )) {
            return true;
        } else {
            HttpSession session = httpServletRequest.getSession ();
            TUsers user = (TUsers) session.getAttribute ( "userInfo" );
            //session中有user不拦截
            if (user != null) {
                return true;
            }else{
                httpServletResponse.sendRedirect ( httpServletRequest.getContextPath () + "/common/renvate" );
            }

            httpServletResponse.sendRedirect ( httpServletRequest.getContextPath () + "/common/login" );

        }
        return true;
    }

    public void postHandle( HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView ) throws Exception {

    }

    public void afterCompletion( HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e ) throws Exception {

    }
}
