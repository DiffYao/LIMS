package com.laoxu.java.bookman.interceptor;

import com.laoxu.java.bookman.model.User;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Description:
 * @Author laoxu
 * @Date 2020/2/3 22:26
 **/
@Component
public class SessionTimeoutInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        // 从session中获取用户信息
        User loginUser = (User) session.getAttribute("loginUser");

        // session过期
        if(loginUser == null){
            response.sendRedirect("/login"); // 通过接口跳转登录页面, 注:重定向后下边的代码还会执行 ; /outToLogin是跳至登录页的后台接口
            return false;
        }else{
            return true;
        }
    }
}
