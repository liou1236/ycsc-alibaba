package com.zrrd.shop.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrrd.shop.client.ProductServiceClient;
import com.zrrd.shop.pojo.Order;
import com.zrrd.shop.pojo.Product;
import com.zrrd.shop.service.OrderService;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;
    private RestTemplate restTemplate;
    private DiscoveryClient discoveryClient;
// 注入一个Feign客户端实例
    private ProductServiceClient productServiceClient;
//    private String productServiceUrl;
    private RocketMQTemplate rocketMQTemplate;

    @Autowired
    public OrderController(OrderService orderService, RestTemplate restTemplate, DiscoveryClient discoveryClient, ProductServiceClient productServiceClient, RocketMQTemplate rocketMQTemplate) {
        this.orderService = orderService;
        this.restTemplate = restTemplate;
        this.discoveryClient = discoveryClient;
        this.productServiceClient =productServiceClient;
        this.rocketMQTemplate = rocketMQTemplate;
    }
//买家下订单购买手机  此时需要远程调用商品服务获取该手机
    //private String productServiceUrl = "http://localhost:8081";//首先要知道商品服务所在的地址
    //定义方法完成手机的下单功能

    //使用feign客户端调用商品服务
    @RequestMapping("/prod/{pid}")
    public Map submitOrder(@PathVariable Integer pid){
        //1、远程调用商品服务查询pid对应的商品信息（商品的名称、价格、库存等）
        //1、远程调用商品服务查询pid对应的商品信息（名称、价格、库存等）
        Map<String,Object> orderMap = new HashMap<>();
        //String orderServiceUrl = productServiceUrl + "/product/" + pid;
        //Product product = restTemplate.getForObject(orderServiceUrl, Product.class);
//        ServiceInstance serviceInstance = discoveryClient.getInstances("shop-product").get(0);
//        productServiceUrl = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/product/";

        /*String serviceId = "shop-product";
        String productServiceUrl = "http://" + serviceId;
        String url = productServiceUrl + "/product/" + pid;
        Product product = restTemplate.getForObject(url, Product.class);*/
        Product product = productServiceClient.detail(pid);
        orderMap.put("远程调用方式","FeignClient");

        if (product.getPid() == -1){
            orderMap.put("调用远程方式","error");
        }

        //2、库存判断是否充足
        if (product.getStock() <= 0){
            orderMap.put("message","库存不足，下单失败");
        }
        //3、如果充足生成订单信息
        Order newOrder = new Order();
        newOrder.setNumber(1);//默认购买数量为一
        newOrder.setPid(product.getPid());
        newOrder.setPname(product.getPname());
        newOrder.setPprice(product.getPprice());
        newOrder.setUid(1);
        newOrder.setUsername("测试用户：小wu");
        orderService.save(newOrder);//保存订单数据

        //4、同步减库存

        //5、下单成功返回订单数据
        orderMap.put("message","下单成功");
        orderMap.put("data",newOrder);
        return orderMap;

    }

    /*
    * 分页使用MP自带的分页拦截器 查询订单数据
    * pageNum第几页
    * pageSize分页显示第几条
    * */
    @GetMapping("/list")
    public Page<Order> list(@RequestParam(defaultValue = "1") Integer pageNum,
                            @RequestParam(defaultValue = "5") Integer pageSize){
        return orderService.page(new Page<>(pageNum,pageSize));
    }
}
