package com.zrrd.utils;

public class LogUtils {
    public void beforeMethod(){
        System.out.println("提供方法，用于原来方法执行之前，进行方法功能的增强（开启事务）");
    }
    public void afterMethod(){
        System.out.println("after");
    }
    public void afterThrowing(){
        System.out.println("提供方法，用于原来方法报错时，在原有方法内部抛出异常时执行(事务回滚)Throwing");
    }
    public void afterReturning(){
        System.out.println("提供方法，用于原来方法代码全部运行完成，到return关键字时(事务提交Returning");
    }
}
