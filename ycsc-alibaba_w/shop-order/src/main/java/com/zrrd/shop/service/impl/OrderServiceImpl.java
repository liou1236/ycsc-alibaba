package com.zrrd.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zrrd.shop.dao.OrderMapper;
import com.zrrd.shop.pojo.Order;
import com.zrrd.shop.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper,Order>implements OrderService {
}
