package com.jt.controller;

import com.jt.pojo.ItemCat;
import com.jt.service.ItemCatService;
import com.jt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Ming
 */
@RestController
@CrossOrigin
@RequestMapping("/itemCat")
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;

    /*
    * 实现商品分类查询
    * url:/itemCat/findItemCatList
    * 参数type
    * 返回值  SysResult对象
    * */
    @GetMapping("/findItemCatList/{type}")
    public SysResult findItemCatList(@PathVariable Integer type){
        List<ItemCat> itemCatList = itemCatService.findItemCatList(type);
        return SysResult.success(itemCatList);
    }
    /*
    * 实现商品分类状态修改
    * url: /itemCat/status/{id}/{status}
    * 参数: id/status
    * 返回值: SysResult对象
    * */
    @PutMapping("/status/{id}/{status}")
    public SysResult updateStatus(ItemCat itemCat){
        itemCatService.updateStatus(itemCat);
        return SysResult.success();
    }
    /*
    * 实现商品分类新增
    * url: /itemCat/saveItemCat
    * */
    @PostMapping("/saveItemCat")
    public SysResult saveItemCat(@RequestBody ItemCat itemCat){
        itemCatService.saveItemCat(itemCat);
        return SysResult.success();
    }
    /*
    * url: /itemCat/updateItemCat
    * 参数: 修改的form表单  json
    * put请求
    * */
    @PutMapping("/updateItemCat")
    public SysResult updateItemCat(@RequestBody ItemCat itemCat){
        itemCatService.updateItemCat(itemCat);
        return SysResult.success();
    }

}
