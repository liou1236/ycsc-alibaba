package com.zrrd.controller;

import com.zrrd.pojo.AxiosPOJO;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin//允许当前类中的所有方法执行跨域操作
public class AxiosController {
    //Axios入门案例
    //CORS error跨域错误
    @GetMapping("/hello")
    public String hello(){
        return "Vue的异步调用";
    }
    @GetMapping("/axios")
    public String getAxios(Integer id){
        return "动态获取id"+id;
    }
    @GetMapping("/axios/{id}")
    public String axiosRestFul(@PathVariable Integer id){
        return "restFul接收参数" + id;
    }
    @GetMapping("/axiosParams")
    public String axiosParams(Integer id){
        return "params获取参数成功";
    }
    @PostMapping("/addAxios")
    public AxiosPOJO addAxios(@RequestBody AxiosPOJO axiosPOJO){
        return axiosPOJO;
    }
    @PostMapping("/addAxiosForm")
    public AxiosPOJO addAxiosForm(AxiosPOJO axiosPOJO){
        return axiosPOJO;
    }

}
