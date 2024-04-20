package com.zrrd.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 自定义记录业务方法名称前置通知
 * 前置通知：目标方法
 **/
public class MyBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("当前执行方法的名称" + method.getName());
        System.out.println("当前执行方法的参数" + objects[0]);
        System.out.println("目标对象" + o);
    }
}
