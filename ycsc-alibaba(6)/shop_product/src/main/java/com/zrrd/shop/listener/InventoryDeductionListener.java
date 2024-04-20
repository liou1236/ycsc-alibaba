package com.zrrd.shop.listener;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zrrd.shop.pojo.Order;
import com.zrrd.shop.pojo.Product;
import com.zrrd.shop.service.ProductService;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : Ming
 */
@Component
@RocketMQMessageListener(topic = "Order",selectorExpression = "Stock",consumerGroup = "${rocketmq.consumer.group}")
public class InventoryDeductionListener implements RocketMQListener<Order> {
    @Autowired
    private ProductService productService;

    @Override
    public void onMessage(Order message) {
        Product product = productService.getById(message.getPid()); //查到的商品对象
        product.setStock(product.getStock()-message.getNumber());//原库存-购买数量=新的库存
        UpdateWrapper<Product> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("pid",product.getPid());
        updateWrapper.set("stock",product.getStock());
        productService.update(updateWrapper);//库存修改成功
    }
}
