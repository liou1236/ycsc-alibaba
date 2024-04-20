package com.jt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.ItemCatParamMapper;
import com.jt.pojo.ItemCatParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : Ming
 */
@Service
public class ItemCatParamServiceImpl implements ItemCatParamService {
    @Autowired
    private ItemCatParamMapper itemCatParamMapper;
    @Override
    public List<ItemCatParam> findParamListByType(ItemCatParam itemCatParam) {
        return itemCatParamMapper.selectList(new QueryWrapper<>(itemCatParam));
    }

    @Override
    @Transactional //事务控制
    public void addItemCatParam(ItemCatParam itemCatParam) {
        itemCatParamMapper.insert(itemCatParam);
    }

    @Override
    @Transactional
    public void updateItemCatParam(ItemCatParam itemCatParam) {
        itemCatParamMapper.updateById(itemCatParam);
    }

    @Override
    public void deleteItemCatParam(Integer paramId) {
        itemCatParamMapper.deleteById(paramId);
    }
}
