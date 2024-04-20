package com.zrrd.service.impl;

import com.zrrd.factory.ProductFactory;
import com.zrrd.pojo.Product;
import com.zrrd.service.Sale;

public class SaleImpl implements Sale {

    @Override
    public void saleProduct(double price) {
        ProductFactory factory = new ProductFactory();
        Product product = factory.make();

        product.setPrice(price);
        System.out.println("product = " + product);
    }
}
