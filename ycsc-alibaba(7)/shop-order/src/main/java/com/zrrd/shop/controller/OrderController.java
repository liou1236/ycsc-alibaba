package com.zrrd.shop.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrrd.shop.client.ProductServiceClient;
import com.zrrd.shop.pojo.Order;
import com.zrrd.shop.pojo.Product;
import com.zrrd.shop.service.OrderService;

import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Ming
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;
    private RestTemplate restTemplate;
    private DiscoveryClient discoveryClient;//专门负责服务注册与发现的 我们可以通过它获取到注册到注册中心的所有服务
    //注入一个Feign客户端实例
    private ProductServiceClient productServiceClient;

    private RocketMQTemplate rocketMQTemplate;
    @Autowired
    public OrderController(OrderService orderService,
                           RestTemplate restTemplate,
                           DiscoveryClient discoveryClient,
                           ProductServiceClient productServiceClient,
                           RocketMQTemplate rocketMQTemplate) {
        this.orderService = orderService;
        this.restTemplate = restTemplate;
        this.discoveryClient = discoveryClient;
        this.productServiceClient = productServiceClient;
        this.rocketMQTemplate = rocketMQTemplate;
    }

    /*
    * 现在 有一个买家要下一笔订单要购买一部诺基亚手机;
    * 我们需要远程调用商品服务以获取诺基亚手机信息
    * */
    //private String productServiceUrl = "http://localhost:8081";//首先要知道商品服务所在的地址

    //定义方法完成手机的下单功能
    //使用feign客户端调用商品服务
    @RequestMapping("/prod/{pid}")
    //@GlobalTransactional//控制当前方法内所有步骤在同一分布式事务中
    public Map submitOrder(@PathVariable("pid") Integer pid){
        //1.远程调用商品服务查询pid对应的商品信息(商品的名称 价格 库存等等)
        Product product = productServiceClient.detail(pid);
        Map result = new HashMap();
        result.put("远程调用方式","FeignClient");

        if (product.getPid() == -1){
            result.put("message","查询商品信息时出错 请稍后重试");
            return result;
        }
        //2.判断库存是否充足
        if (product.getStock() <= 0){//库存不足
            result.put("message","库存不足,下单失败~");
            return result;
        }
        //如果充足 3.生成订单信息
        Order newOrder = new Order();
        newOrder.setNumber(1); //默认购买数量为1
        newOrder.setPid(product.getPid());//商品id
        newOrder.setPname(product.getPname());//商品名称
        newOrder.setPprice(product.getPprice());//商品价格
        newOrder.setNumber(1);//购买商品的数量
        newOrder.setUid(1);//用户id默认为1
        newOrder.setUsername("测试用户:小五");
        orderService.save(newOrder);//保存订单数据
        //4.扣掉商品的库存(暂时不写)
        //直接调用远程商品服务完成扣库存的操作
        productServiceClient.subStock(pid,1);
        //向MQ发送一条扣库存的指令
        /*SendResult sendResult = rocketMQTemplate.syncSend("Order:Stock", newOrder);
        System.out.println(sendResult);*/
        //5.下单成功返回订单数据
        result.put("message","下单成功~");
        result.put("data",newOrder);
        return result;
    }

    /*
    * 分页(使用mybatis-plus自带的分页拦截器 查询订单数据)
    * pageNum 第几页
    * pageSize 煤业显示几条
    * */
    @GetMapping("/list")
    public Page<Order> list(@RequestParam(defaultValue = "1") Integer pageNum,
                            @RequestParam(defaultValue = "5") Integer PageSize){
        return orderService.page(new Page<>(pageNum,PageSize));
    }
}
