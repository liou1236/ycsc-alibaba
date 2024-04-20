//package com.zrrd.proxy.dynamicproxy;
//
//import com.sun.org.apache.regexp.internal.RE;
//import com.zrrd.service.UserService;
//import com.zrrd.service.impl.UserServiceImpl;
//
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//
//public class DynamicProxy implements InvocationHandler {
//    private UserService userService;
//
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
//
//    // 生成代理类
//    public Object getProxy(){
//        return Proxy.newProxyInstance(getClass().getClassLoader(),userService.getClass().getInterfaces(),this);
//    }
//
//    @Override
//    public Object invoke(Object proxy, Method method, Object[] objects) throws Throwable {
//        before();
//        Object result = method.invoke(userService, objects);
//        after();
//        return result;
//    }
//    public void before(){
//        System.out.println("开启事务");
//    }
//    public void after(){
//        System.out.println("关闭事务");
//    }
//
//}
//class Client{
//    public static void main(String[] args) {
//        UserServiceImpl userService = new UserServiceImpl();
//        DynamicProxy dynamicProxy = new DynamicProxy();
//        dynamicProxy.setUserService(userService);
//        UserService proxy =(UserService) dynamicProxy.getProxy();
//        String result = proxy.save("xiao");
//        System.out.println("result = " + result);
//    }
//}
