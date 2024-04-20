package com.jt.controller;

import com.jt.pojo.Item;
import com.jt.service.ItemService;
import com.jt.vo.ItemVO;
import com.jt.vo.PageResult;
import com.jt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Ming
 */
@RestController
@CrossOrigin
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;
    /*
    * 实现商品列表展现
    * */
    @GetMapping("/getItemList")
    public SysResult findItemList(PageResult pageResult){
        //查询分页数据 返回分页对象
        pageResult = itemService.findItemList(pageResult);
        return SysResult.success(pageResult);

    }

    /*
    * url: /item/updateItemStatus
    * 请求参数: 利用Item对象接收
    * id: item.id
    * status: item.status
    * 返回值: SysResult对象
    * */
    @PutMapping("/updateItemStatus")
    public SysResult updateItemStatus(Item item){
        itemService.updateItemStatus(item);
        return SysResult.success();
    }
    /*
    * 商品新增
    * url: /item/saveItem
    * 参数:{item,itemDesc,ItemParam} 使用ItemVO接收
    * 返回值对象: SysResult对象
    * */
    @PostMapping("/saveItem")
    public SysResult saveItem(@RequestBody ItemVO itemVO){
        itemService.saveItem(itemVO);
        return SysResult.success();
    }



}
