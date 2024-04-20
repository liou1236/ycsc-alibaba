package com.zrrd.shop.ums.controller;

import com.zrrd.shop.ums.service.IResourceService;
import com.zrrd.shop.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 后台资源表 前端控制器
 * </p>
 *
 * @author Ming
 * @since 2024-04-02
 */
@RestController
@RequestMapping("/resource")
@Api(tags = "资源管理接口列表")
public class ResourceController {
    @Autowired
    private IResourceService resourceService;
    @GetMapping("/listAll")
    @ApiOperation("查询全部资源")
    public ResponseResult listAll(){
        return new ResponseResult(200,"查询完成",resourceService.list());
    }

    @GetMapping("/list")
    @ApiOperation("分页查询资源列表")
    public ResponseResult list(@RequestParam(required = false) @ApiParam("资源名称关键字") String nameKeyword,
                               @RequestParam(required = false) @ApiParam("资源路径关键字") String urlKeyword,
                               @RequestParam(required = false) @ApiParam("资源分类的ID") Integer categoryId,
                               @RequestParam(defaultValue = "1") @ApiParam(value = "页号",required = true) Integer pageNum,
                               @RequestParam(defaultValue = "10") @ApiParam(value = "页的大小",required = true) Integer pageSize){
      return null;
    }
}
