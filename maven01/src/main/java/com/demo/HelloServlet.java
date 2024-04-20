package com.demo;

import javax.servlet.*;
import java.io.IOException;

public class HelloServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
//        servlet初始化方法
        System.out.println("初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
//            使用servlet时要做的业务
//        servletRequest   请求
//        servletResponse   响应
//        servletResponse.setContentType("text/html;charset=utf-8");

        servletResponse.setCharacterEncoding("gb2312");
        servletResponse.getWriter().println("success");
        servletResponse.getWriter().println("fail");
        System.out.println("我被执行了");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
//销毁方法
        System.out.println("死了");
    }
}
