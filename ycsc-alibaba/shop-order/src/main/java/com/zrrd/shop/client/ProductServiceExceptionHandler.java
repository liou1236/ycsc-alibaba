package com.zrrd.shop.client;

import com.zrrd.shop.pojo.Product;
import com.zrrd.shop.util.ResponseResult;
import org.springframework.stereotype.Component;

/**
 * @author : Ming
 */
//当远程调用商品服务的接口出错时 执行这个实现类中的异常处理方法
@Component
public class ProductServiceExceptionHandler implements ProductServiceClient {
    @Override
    public Product detail(Integer pid) {
        Product product = new Product();
        product.setPid(-1); //默认返回一个id为-1的商品
        return product;
    }

    @Override
    public ResponseResult subStock(Integer pid, Integer num) {
        return null;
    }
}
