package com.zrrd.shop.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zrrd.shop.pojo.Product;
import com.zrrd.shop.service.ProductService;
import com.zrrd.shop.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/list")
    public List<Product> list(){
        return productService.list();
    }

    @GetMapping("/{pid}")
    public Product detail(@PathVariable Integer pid){
//        if (new Random().nextBoolean()){//如果程序生成的随机数为true  程序抛出异常
//            throw new RuntimeException("手动模拟程序出错");
//        }
        try {
            TimeUnit.MICROSECONDS.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productService.getById(pid);
    }

    @PostMapping("/subStock")
    public ResponseResult subStock(Integer pid, Integer num){
        Product product = productService.getById(pid);
        product.setStock(product.getStock() - num);
        UpdateWrapper<Product> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("pid",product.getPid());
        updateWrapper.set("stock",product.getStock());
        productService.update(updateWrapper);//库存修改成功
        return new ResponseResult(200,"扣库存成功");
    }

}
