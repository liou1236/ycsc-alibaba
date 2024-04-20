package com.jt.aop;

import com.jt.vo.SysResult;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@Component @Aspect @AfterThrowing
@RestControllerAdvice//定义全局异常处理 拦截Controller层 返回json
public class AOPException {
    /*
    异常通知
    1、拦截什么类型的异常
    2、拦截之后如何处理
     */
    @ExceptionHandler({RuntimeException.class})
    public Object exception(Exception e){
        //将异常 可以控制台输出
        e.printStackTrace();
        return SysResult.fail();
    }
}
