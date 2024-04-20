package com.zrrd.controller;

import com.zrrd.pojo.User;
import org.apache.catalina.mbeans.SparseUserDatabaseMBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Controller
public class UserController {

    /*
    常规get请求：
    url:http://localhost:8090/restFul?id=1&name=tom

    RestFul结构：
    url:http://localhost:8090/restFul/{id}/{name}
        1、参数之间使用/进行分割
        2、参数位置一旦确定就不能改变
        3、参数使用{}号进行包裹，并设定形参
        4、在接受参数时，使用特定的注解取值@PathVariable
    @PathVariable:参数说明
         1、name/value 动态接受形参数据 如果参数相同则可以省略不写
         2、必填项 require 默认值为true

         get:查 post:增 put:改 delete:删
     */
@RequestMapping(value = "/restFul/{id}/{name}",method = RequestMethod.GET)
//@RequestMapping(value = "/restFul/{id}/{name}",method = RequestMethod.POST)
//@RequestMapping(value = "/restFul/{id}/{name}",method = RequestMethod.DELETE)
//@RequestMapping(value = "/restFul/{id}/{name}",method = RequestMethod.PUT)
//    @GetMapping("/restFul/{id}/{name}")
    public String restFul(@PathVariable Integer id,
                          @PathVariable String name){
    System.out.println("参数获取"+id+" | "+name);
    return "success";
    }

    /*
    测试转发和重定向
    1、findUser请求
    2、转发到findDog请求
    3、关键字：forward:转发的是一个请求
     */
    @RequestMapping("/findUser")
    public String findUser(String name){
        return "forward:/findDog";
    }
//    @RequestMapping("/findUser")
//    public String findUser(String name){
//        return "redirect:/findDog";
//    }

    @RequestMapping("/findDog")
    public String findDog(String name,Model model){
        System.out.println("获取动态属性值："+name);
        model.addAttribute("name",name+"旺旺");
        return "dog";
    }
    /*
    使用对象的方式接受参数
     */
    @RequestMapping("/addUser")
    private String addUser(User user){
        System.out.println(user);
        return "success";
    }
    /*
    同名提交测试
    url参数 id:name:hobbies
    参数提交形式:SpringMVC自动将参数进行”,“拼接 敲代码，敲键盘，敲主机
    可变参数-String... hobbies
     */
//    @RequestMapping("/addUser")
    public String addHobbies(Integer id,String name,String[] hobbies){
        System.out.println("参数获取：" + id + ":" + name + ":" + Arrays.toString(hobbies));
        return "success";
    }

//    @RequestMapping("/addUser")
//    public String  addUserParam(@RequestParam(value = "id",required = true,defaultValue = "1001")Integer id,
//                                @RequestParam(value = "name",required = true,defaultValue = "张三")String name){
//        System.out.println("参数获取：" + id + name );
//        return "success";
//    }
    // servlet缺点：接受的参数都是String类型
//    @RequestMapping("/addUser")
//    public String addUser(Integer id,String name){
//        System.out.println("参数获取：" + id + name);
//        return "success";
//    }

//    @RequestMapping("/addUser")
//    public String adduser(HttpServletRequest request){
//        Integer id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        System.out.println("参数: "+id+name);
//        return "success";
//    }
    @RequestMapping("/user")
    public String toUser(Model model){
        model.addAttribute("id",2220);
        model.addAttribute("name","SpringMVC");
        return "user";

//    @RequestMapping("/user")
//    public ModelAndView toUser(

//        //mvc底层数据传输原则
//        //url:http://localhost:8090/user
//        /*
//        ModelAndView：
//        1、model：封装数据的
//        2、view：封装视图
//         */
//        ModelAndView modelAndView = new ModelAndView();
//        //封装数据库
//        modelAndView.addObject("id",1001);
//        modelAndView.addObject("name","安其拉");
//
//        modelAndView.setViewName("user");
//        return modelAndView;
    }
}
