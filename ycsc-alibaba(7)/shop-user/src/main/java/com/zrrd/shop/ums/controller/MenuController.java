package com.zrrd.shop.ums.controller;

import com.alibaba.nacos.shaded.org.checkerframework.checker.units.qual.A;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrrd.shop.ums.entity.Menu;
import com.zrrd.shop.ums.service.IMenuService;
import com.zrrd.shop.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * 后台菜单表 前端控制器
 * </p>
 *
 * @author Ming
 * @since 2024-04-02
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private IMenuService menuService;
    @GetMapping("/treeList")
    @ApiOperation("查询菜单的树状图")
    public ResponseResult treeList(){
        //首先要查询0级菜单 且被隐藏的
        QueryWrapper<Menu> queryWrapper=new QueryWrapper<Menu>();
        queryWrapper.eq("level",0);
        queryWrapper.eq("hidden",0);
        List<Menu> menuList = menuService.list(queryWrapper);
        for (Menu parent : menuList) {
            queryWrapper.clear();//清除原来的全部查询条件
            queryWrapper.eq("parent_id",parent.getId());
            queryWrapper.eq("hidden",0);
            parent.setChildren(menuService.list(queryWrapper));//查询父节点全部子节点
        }
        return new ResponseResult(200,"查询完成",menuList);
    }

    @GetMapping("/list/{parentId}")
    @ApiOperation("查询列表")
    public ResponseResult list(@PathVariable@ApiParam(value = "父级id") Long parentId,
                               @RequestParam(defaultValue = "1")@ApiParam(value = "页号") Integer pageNum,
                               @RequestParam(defaultValue = "10") @ApiParam(value = "页号大小") Integer pageSize){
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",parentId);
        Page page = new Page(pageNum, pageSize);
        menuService.page(page, queryWrapper);
        return new ResponseResult(200,"查询完成",page);
    }

    @PostMapping("/delete/{id}")
    @ApiOperation("删除菜单")
    public ResponseResult delete(@PathVariable @ApiParam(value = "菜单id",required = true) Long id){
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id)
                .or()
                .eq("parent_id",id);//删除菜单机器子菜单
        menuService.remove(queryWrapper);
        return new ResponseResult(200,"删除成功");
    }

    @PostMapping("/create")
    @ApiOperation("创建新菜单")
    public ResponseResult create(@RequestBody Menu menu){
        menu.setCreateTime(LocalDateTime.now());
        if (menu.getParentId()==0){
            menu.setLevel(0);
        }else {
            menu.setLevel(1);
        }
        menuService.save(menu);
        return new ResponseResult(200,"创建成功");
    }
    @GetMapping("/{id}")
    @ApiOperation("菜单查询详情")
    public ResponseResult detail(@PathVariable @ApiParam(value = "菜单id",required = true)Long id){
        return new ResponseResult(200,"查询完成",menuService.getById(id));
    }

    @PostMapping("/update/{id}")
    public ResponseResult update(@PathVariable @ApiParam(value="菜单id",required = true)Long id,@RequestBody Menu menu){
        menu.setId(id);
        menuService.updateById(menu);
        return new ResponseResult(200,"修改成功");
    }

    @PostMapping("/updateHidden/{id}")
    @ApiOperation("更改状态")
    public ResponseResult updateHidden(@PathVariable @ApiParam(value="id",required = true) Integer id,
                                       @RequestParam @ApiParam(value="状态",required = true,allowableValues = "0,1") Integer hidden){
        UpdateWrapper<Menu> updatemenu = new UpdateWrapper<>();
        updatemenu.eq("id",id);
        updatemenu.set("hidden",hidden);
        menuService.update(updatemenu);
        return new ResponseResult(200,"修改成功");
    }


}
