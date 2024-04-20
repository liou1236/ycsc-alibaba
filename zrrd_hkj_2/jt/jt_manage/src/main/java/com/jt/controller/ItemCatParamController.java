package com.jt.controller;

import com.jt.pojo.ItemCatParam;
import com.jt.service.ItemCatParamService;
import com.jt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Ming
 */
@RestController
@CrossOrigin
@RequestMapping("/itemCatParam")
public class ItemCatParamController {
    @Autowired
    private ItemCatParamService itemCatParamService;

    /*
    * 实现商品分类参数实现
    * url: /itemCatParam/findItemCatParamListByType?itemCatId=555&paramType=1
    * 参数: itemCatId paramType
    * 返回值: SysResult对象
    * */
    @GetMapping("/findItemCatParamListByType")
    public SysResult findItemCatParamListByType(ItemCatParam itemCatParam){

        List<ItemCatParam> paramList = itemCatParamService.findParamListByType(itemCatParam);
        return SysResult.success(paramList);
    }
    /*
    * 实现商品分类新增操作
    * url: /itemCatParam/addItemCatParam
    * 参数: itemCatParam接收
    * 返回值: SysRest对象
    * */
    @PostMapping("/addItemCatParam")
    public SysResult addItemCatParam(@RequestBody ItemCatParam itemCatParam){

        itemCatParamService.addItemCatParam(itemCatParam);
        return SysResult.success();
    }

    /*
    * 实现商品分类参数的更新
    * url:"/itemCatParam/updateItemCatParam"
    * 参数: ItemCatParam
    * 返回值: SysResult对象
    * */
    @PutMapping("/updateItemCatParam")
    public SysResult updateItemCatParam(@RequestBody ItemCatParam itemCatParam){
        itemCatParamService.updateItemCatParam(itemCatParam);
        return SysResult.success();
    }

    /**
     * 商品分类参数的删除
     * url:deleteItemCatParamById
     * @param paramId
     * @return
     */
    @DeleteMapping("/deleteItemCatParamById")
    public SysResult deleteItemCatParamById(Integer paramId){
        itemCatParamService.deleteItemCatParam(paramId);
        return SysResult.success();
    }
}
