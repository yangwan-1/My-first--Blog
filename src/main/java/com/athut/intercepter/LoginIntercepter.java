package com.athut.intercepter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author yangwan
 * @create 2021-04-12 14:50
 */
@Slf4j
public class LoginIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        log.info("拦截的请求地址是"+uri);
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if (user != null){
            return true;
        }
        else {
            request.setAttribute("msg","请先登录");
            request.getRequestDispatcher("/admin").forward(request,response);
            return false;
        }
    }
}
