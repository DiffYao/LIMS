package com.laoxu.java.bookman.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 测试
 * @author: laoxu
 * @create: 2019-04-17
 **/
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello BookMan!";
    }

}
