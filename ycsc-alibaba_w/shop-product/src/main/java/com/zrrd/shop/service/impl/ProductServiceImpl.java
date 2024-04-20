package com.zrrd.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zrrd.shop.dao.ProductMapper;
import com.zrrd.shop.pojo.Product;
import com.zrrd.shop.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
