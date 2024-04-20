package com.jt.service;

import com.jt.pojo.ItemCat;

import java.util.List;

/**
 * @author : Ming
 */
public interface ItemCatService {

    List<ItemCat> findItemCatList(Integer type);

    void updateStatus(ItemCat itemCat);

    void saveItemCat(ItemCat itemCat);

    void deleteItemCat(ItemCat itemCat);

    void updateItemCat(ItemCat itemCat);
}
