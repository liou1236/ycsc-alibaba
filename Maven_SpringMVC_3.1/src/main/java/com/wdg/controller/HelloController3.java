package com.wdg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
//加子目录，目的为了过滤拦截
@RequestMapping("admin")
public class HelloController3 {
    //接受请求，封装数据，调用业务逻辑，返回处理结果的数据到视图页面
    @RequestMapping("/hello3.action")
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, ModelAndView mv) throws Exception {
        mv.addObject("msg", "这是我的第三个SpringMVC程序！");
        //设置回显视图页面
        mv.setViewName("/jsp/first.jsp");
        //返回模型视图
        return mv;
    }

    @RequestMapping("/hello4.action")
    public String hello(Model mo) {
        mo.addAttribute("msg", "这是我的第四个SpringMVC程序！");
        return "/jsp/first.jsp";
    }
    @RequestMapping("/hello5.action")
    public String hello5(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("msg","这是我的第五个SpringMVC程序！");
        return "/jsp/first.jsp";
    }
    @RequestMapping("/hello6.action")
    public void hello6(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("msg","这是我的第六个SpringMVC程序！");
        request.getRequestDispatcher("/jsp/first.jsp").forward(request,response);
    }
}
