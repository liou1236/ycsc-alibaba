package com.zrrd.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zrrd.shop.dao.ProductMapper;
import com.zrrd.shop.pojo.Product;
import com.zrrd.shop.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @author : Ming
 */
/*
* 自定义service实现类 需要实现我们自定义的业务接口 同时继承mybatis-plus自带的ServiceImpl的实现类
* ServiceImpl<Mapper接口名,Pojo类名>
* */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
