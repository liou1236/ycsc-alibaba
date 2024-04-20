package com.zrrd.shop.ums.controller;

import com.zrrd.shop.ums.service.IResourceCategoryService;
import com.zrrd.shop.util.ResponseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

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
}
