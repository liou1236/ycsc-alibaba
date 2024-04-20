package com.zrrd.shop.client;

import com.zrrd.shop.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "shop-product",fallback = ProductServiceExceptionHandler.class)
public interface ProductServiceClient {
    @GetMapping("/product/{pid}")
    Product detail( @PathVariable Integer pid);
}
