package com.zrrd.shop.ums.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrrd.shop.ums.entity.Menu;
import com.zrrd.shop.ums.service.IMenuService;
import com.zrrd.shop.util.ResponseResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.junit.experimental.theories.DataPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

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
    private IMenuService iMenuService;

    @GetMapping("/treeList")
    @ApiOperation("查询菜单的树状图")
    public ResponseResult treeList(){
        //首先查询0级菜单且被隐藏的
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("level",0);
        queryWrapper.eq("hidden",0);
        List<Menu> menuList = iMenuService.list(queryWrapper);
        for (Menu parent:menuList
             ) {
            queryWrapper.clear();//在设置新的查询条件之前将原来的条件清除
            queryWrapper.eq("parent_id",parent.getId());
            queryWrapper.eq("hidden",0);
            parent.setChildren(iMenuService.list(queryWrapper));

        }
        return new ResponseResult(200,"查询完成",menuList);
    }

    @GetMapping("/list/{parentId}")
    @ApiOperation("查询菜单列表")
    public ResponseResult list(@PathVariable(required = false) @ApiParam(value = "父级菜单Id") Long parentId,
                               @RequestParam(defaultValue = "1") @ApiParam(value = "页号")Integer pageNum,
                               @RequestParam(defaultValue = "10") @ApiParam(value = "页大小")Integer pageSize){
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",parentId);
        Page page = new Page(pageNum,pageSize);
        iMenuService.page(page,queryWrapper);
        return new ResponseResult(200,"查询完成",page);
    }
    @PostMapping("/delete/{id}")
    @ApiOperation("删除菜单")
    public ResponseResult delete(@PathVariable @ApiParam(value = "菜单id",required = true)Long id){
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id)
                .or()
                .eq("parent_id",id);//删除菜单及其子菜单
        iMenuService.remove(queryWrapper);
        return new ResponseResult(200,"删除成功");
    }
    @PostMapping("/create")
    @ApiOperation("创建新菜单")
    public ResponseResult create(@RequestBody Menu menu){
        menu.setCreateTime(LocalDateTime.now());
        if (menu.getParentId() == 0)//判断是否是顶级菜单
            menu.setLevel(0);
        else
            menu.setLevel(1);
        iMenuService.save(menu);
        return new ResponseResult(200,"创建成功");
    }
    @GetMapping("/{id}")
    @ApiOperation("菜单查询详情")
    public ResponseResult detail(@PathVariable @ApiParam(value = "菜单id",required = true)Long id){
        return new ResponseResult(200,"查询完成",iMenuService.getById(id));
    }

    @PostMapping("/update/{id}")
    public ResponseResult update(@PathVariable @ApiParam(value = "菜单id",required = true)Long id,
                                 @RequestBody Menu menu){
        menu.setId(id);
        iMenuService.updateById(menu);
        return new ResponseResult(200,"修改成功");
    }
}
