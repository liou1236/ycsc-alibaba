package com.demo.web;

import com.demo.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet  extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        //1. 接收表单提交的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //2.调用业务层处理数据
        UserService userService = new UserService();
        boolean isLogin= userService.login(username,password);
        //3.  根据处理结果显示页面信息（实现页面跳转）
        if (isLogin){
            //登录成功
            resp.getWriter().println("登录成功");
        }else {
            //登录失败
            resp.getWriter().println("登录失败");
        }


    }
}
