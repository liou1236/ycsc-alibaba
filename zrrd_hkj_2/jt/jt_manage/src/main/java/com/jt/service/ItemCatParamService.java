package com.jt.service;

import com.jt.pojo.ItemCatParam;

import java.util.List;

/**
 * @author : Ming
 */
public interface ItemCatParamService {
    List<ItemCatParam> findParamListByType(ItemCatParam itemCatParam);

    void addItemCatParam(ItemCatParam itemCatParam);

    void updateItemCatParam(ItemCatParam itemCatParam);

    void deleteItemCatParam(Integer paramId);
}
