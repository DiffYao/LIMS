package com.laoxu.java.bookman.framework;

import com.laoxu.java.bookman.exception.UnAuthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 异常处理器
 * @Author laoxu
 * @Date 2019/7/3 22:14
 **/
@ControllerAdvice
public class ExceptionsHandler {
    @ResponseBody
    @ExceptionHandler(UnAuthorizedException.class)//可以直接写@ExceptionHandler,不指明异常类，会自动映射
    public Result<String> customGenericExceptionHnadler(UnAuthorizedException exception){ //还可以声明接收其他任意参数
        return ResultUtil.fail(Integer.valueOf(exception.getErrorCode()),exception.getErrorMessage());
    }
}
