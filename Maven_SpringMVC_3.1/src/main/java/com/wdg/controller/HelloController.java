package com.wdg.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
//自定义处理器，调用springMVC框架接口
public class HelloController implements Controller {
    //接受请求，封装数据，调用业务逻辑，返回处理结果的数据到视图页面
    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws Exception {
        //创建视图模型对象
        ModelAndView mv = new ModelAndView();
        //给模型加载数据
        mv.addObject("msg", "这是我的第一个SpringMVC程序！");
        //设置回显视图页面
        mv.setViewName("/jsp/first.jsp");
        //返回模型视图
        return mv;
    }
}
