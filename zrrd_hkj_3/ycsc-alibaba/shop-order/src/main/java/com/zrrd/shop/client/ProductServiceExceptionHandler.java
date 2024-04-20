package com.zrrd.shop.client;

import com.alibaba.nacos.shaded.org.checkerframework.checker.units.qual.C;
import com.zrrd.shop.pojo.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceExceptionHandler implements ProductServiceClient{
    @Override
    public Product detail(Integer pid) {
        Product product = new Product();
        product.setPid(-1);
        return product;
    }
}
