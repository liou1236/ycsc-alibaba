package com.zrrd.shop.ums.controller;

import com.zrrd.shop.ums.entity.ResourceCategory;
import com.zrrd.shop.ums.service.IResourceCategoryService;
import com.zrrd.shop.util.ResponseResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

/**
 * <p>
 * 资源分类表 前端控制器
 * </p>
 *
 * @author Ming
 * @since 2024-04-02
 */
@RestController
@RequestMapping("/resourceCategory")
public class ResourceCategoryController {
    @Autowired
    private IResourceCategoryService resourceCategoryService;

    @GetMapping("/listAll")
    @ApiOperation("查询所有的资源分类")
    public ResponseResult listAll(){
        return new ResponseResult(200,"查询完成",resourceCategoryService.list());
    }
    @PostMapping("/create")
    @ApiOperation("/创建一个资源分类")
    public ResponseResult create(@RequestBody ResourceCategory resourceCategory){
        resourceCategory.setCreateTime(LocalDateTime.now());
        resourceCategoryService.save(resourceCategory);
        return new ResponseResult(200,"创建成功");
    }
    @PostMapping("/update/{id}")
    public ResponseResult update(@PathVariable @ApiParam(value = "资源分类id",required = true) Long id,
                                 @RequestBody ResourceCategory resourceCategory){
        resourceCategory.setId(id);
        resourceCategoryService.updateById(resourceCategory);
        return new ResponseResult(200,"修改成功");
    }

    @PostMapping("/delete/{id}")
    public ResponseResult delete(@PathVariable @ApiParam(value = "资源分类id",required = true) Long id){
        resourceCategoryService.removeById(id);
        return new ResponseResult(200,"删除成功");
    }
}
