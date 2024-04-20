package com.zrrd.shop.controller;

import com.zrrd.shop.pojo.Product;
import com.zrrd.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author : Ming
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public List<Product> list(){
        return productService.list();
    }
    @GetMapping("/{pid}")
    public Product detail(@PathVariable Integer pid){
        /*if (new Random().nextBoolean()){//如果生成的随机数为true 程序就会抛出异常
            throw new RuntimeException("手动模拟程序出错了");
        }*/
        try {
            TimeUnit.MICROSECONDS.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productService.getById(pid);
    }
}
