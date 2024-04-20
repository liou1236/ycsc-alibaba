package com.wdg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController4 {
    @RequestMapping("/hello7.do")
    public String hello(HttpServletRequest request){
        String s="方法一";
        request.setAttribute("msg1",s);
        System.out.println(s);
        return "first";
    }
    @RequestMapping("/hello8.do")
    public String hello8(HttpServletRequest request){
        String s="方法二";
        request.setAttribute("msg2",s);
        System.out.println(s);
        return "redirect:hello7.do";
    }
    @RequestMapping("/hello9.do")
    public String hello9(HttpServletRequest request){
        String s="方法三";
        request.setAttribute("msg3",s);
        System.out.println(s);
        return "forward:hello7.do";
    }
}
