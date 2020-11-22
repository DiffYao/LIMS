package com.laoxu.java.bookman.config;

import com.laoxu.java.bookman.common.SecurityUtil;
import com.laoxu.java.bookman.model.User;
import com.laoxu.java.bookman.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: 自定义登录成功处理类
 * @Author laoxu
 * @Date 2019/5/25 23:32
 **/
@Component
public class MyAuthenctiationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Autowired
    UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");

        RequestCache cache = new HttpSessionRequestCache();
        SavedRequest savedRequest = cache.getRequest(request, response);
        // 如果来源请求为空则跳转到管理后台
        String url = "admin";
        /*if((savedRequest==null)){
            url = "admin";
        }else{
            url = savedRequest.getRedirectUrl();
        }*/

        // 获取登录用户详细信息
        User user = userService.getUserByUsername(SecurityUtil.getLoginUser());
        request.getSession().setAttribute("loginUser",user);

        // 返回jwt
        response.sendRedirect(url);
    }
}
