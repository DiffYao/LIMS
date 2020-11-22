package com.laoxu.java.bookman.controller;

import com.laoxu.java.bookman.common.MD5Util;
import com.laoxu.java.bookman.common.SecurityUtil;
import com.laoxu.java.bookman.framework.Result;
import com.laoxu.java.bookman.framework.ResultUtil;
import com.laoxu.java.bookman.model.Book;
import com.laoxu.java.bookman.model.User;
import com.laoxu.java.bookman.service.BookBorrowService;
import com.laoxu.java.bookman.service.BookService;
import com.laoxu.java.bookman.service.UserService;
import com.laoxu.java.bookman.vo.BookBorrowVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Description: 用户控制器
 * @Author laoxu
 * @Date 2020/2/3 22:40
 **/
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    /**
     *  修改密码
     * @param param
     * @return
     */
    @PostMapping("/modifyPassword")
    public Result<String> bookEdit(@RequestBody Map<String,String> param){
        // 校验密码
        String oldPassword = param.get("oldPassword");
        String newPassword = param.get("newPassword");
        String newPassword2 = param.get("newPassword2");

        if(StringUtils.isEmpty(oldPassword)){
            return ResultUtil.fail("原密码不能为空！");
        }

        if(StringUtils.isEmpty(newPassword)){
            return ResultUtil.fail("新密码不能为空！");
        }

        if(StringUtils.isEmpty(newPassword2)){
            return ResultUtil.fail("确认密码不能为空！");
        }

        oldPassword = MD5Util.encode(oldPassword);
        User user = userService.getUserByUsername( SecurityUtil.getLoginUser());
        String realPassword = user.getPassword();
        if(!(oldPassword.equals(realPassword))){
            return ResultUtil.fail("原密码输入错误！");
        }

        if(!(newPassword.equals(newPassword2))){
            return ResultUtil.fail("新密码输入不一致！");
        }

        user.setPassword(MD5Util.encode(newPassword));

        userService.modify(user);

        return ResultUtil.ok();
    }


}
