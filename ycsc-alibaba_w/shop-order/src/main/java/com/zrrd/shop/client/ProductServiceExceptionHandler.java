package com.zrrd.shop.client;

import com.alibaba.nacos.shaded.org.checkerframework.checker.units.qual.C;
import com.zrrd.shop.pojo.Product;
import com.zrrd.shop.util.ResponseResult;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceExceptionHandler implements ProductServiceClient{
    @Override
    public Product detail(Integer pid) {
        Product product = new Product();
        product.setPid(-1);
        return product;
    }

    @Override
    public ResponseResult subStock(Integer pid, Integer num) {
        return null;
    }
}
