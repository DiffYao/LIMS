package com.laoxu.java.bookman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @Author laoxu
 * @Date 2020/2/3 22:41
 **/
//@Controller
public class AdminController {
    @RequestMapping("/timeout")
    public void bookEdit(HttpServletResponse response) throws IOException {
        response.sendRedirect("/login");
    }
}
