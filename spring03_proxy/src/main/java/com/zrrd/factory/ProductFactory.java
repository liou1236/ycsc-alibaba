package com.zrrd.factory;

import com.zrrd.pojo.Product;

public class ProductFactory {
    public Product make(){
        Product p = new Product();
        p.setPrice(900);
        p.setName("xiaomi");
        return p;
    }
}
