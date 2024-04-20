package com.zrrd.shop.client;

import com.zrrd.shop.pojo.Product;
import com.zrrd.shop.util.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : Ming
 */
//name属性定义我们要调用的服务id(在nacos中注册的服务id)
@FeignClient(name = "shop-product",fallback = ProductServiceExceptionHandler.class)
public interface ProductServiceClient {
    @GetMapping("/product/{pid}")
    Product detail(@PathVariable Integer pid);
    @PostMapping("/product/subStock")
    ResponseResult subStock(@RequestParam Integer pid, @RequestParam Integer num);

}
