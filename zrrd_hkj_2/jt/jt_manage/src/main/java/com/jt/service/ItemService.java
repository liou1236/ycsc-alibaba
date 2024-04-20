package com.jt.service;

import com.jt.pojo.Item;
import com.jt.vo.ItemVO;
import com.jt.vo.PageResult;

/**
 * @author : Ming
 */
public interface ItemService {
    PageResult findItemList(PageResult pageResult);


    void updateItemStatus(Item item);

    void saveItem(ItemVO itemVO);
}
