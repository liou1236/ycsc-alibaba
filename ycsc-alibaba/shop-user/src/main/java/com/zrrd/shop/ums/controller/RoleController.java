package com.zrrd.shop.ums.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrrd.shop.ums.entity.Role;
import com.zrrd.shop.ums.service.IMenuService;
import com.zrrd.shop.ums.service.IRoleService;
import com.zrrd.shop.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

/**
 * <p>
 * 后台用户角色表 前端控制器
 * </p>
 *
 * @author Ming
 * @since 2024-04-02
 */
@RestController
@RequestMapping("/role")
@Api(tags = "角色接口管理列表")
public class RoleController {
    @Autowired
    private IRoleService roleService;
    @PostMapping("/create")
    @ApiOperation("创建新角色")
    public ResponseResult create(@RequestBody Role role){
        role.setCreateTime(LocalDateTime.now());//设置创建的时间和日期
        roleService.save(role);//保存这个角色
        return new ResponseResult(200,"创建成功");
    }
    @PostMapping("/update/{id}")
    @ApiOperation("修改角色信息")
    public ResponseResult update(@RequestBody Role role,
                                 @PathVariable @ApiParam(value = "角色id",required = true) Long id){
        role.setId(id);
        roleService.updateById(role);
        return new ResponseResult(200,"修改成功");
    }
    @PostMapping("/updateStatus/{id}")
    @ApiOperation("更新角色状态")
    public ResponseResult updateStatus(
            @PathVariable @ApiParam(value = "角色id",required = true) Long id,
            @RequestParam @ApiParam(value = "角色状态:1-启用 0-禁用",allowableValues = "0,1") Integer status){
        UpdateWrapper<Role> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",id);
        updateWrapper.set("status",status);
        roleService.update(updateWrapper);
        return new ResponseResult(200,"修改成功");
    }

    @PostMapping("/delete")
    @ApiOperation("删除角色(支持批量删除)")
    public ResponseResult delete(@RequestParam @ApiParam(value = "角色id列表",example = "1,2,3") String ids){
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id",ids.split(","));//where id in(1,2,3)
        roleService.remove(queryWrapper);
        return new ResponseResult(200,"删除成功");
    }

    @Autowired
    private IMenuService menuService;
    @GetMapping("/listMenu/{roleId}")
    @ApiOperation("查询该角色对应的菜单列表")
    public ResponseResult listMenu(@PathVariable @ApiParam(value = "角色id",required = true) Long roleId){
        return new ResponseResult(200,"查询完成",menuService.listByRoleId(roleId));
    }





    @GetMapping("/listAll")
    @ApiOperation("查询全部的角色")
    public ResponseResult listAll(){
        return new ResponseResult(200,"查询完成",roleService.list());
    }
    @GetMapping("/list")
    @ApiOperation("分页查询角色列表")
    public ResponseResult list(@RequestParam(required = false) @ApiParam(value = "角色名称") String keyword,
                               @RequestParam(defaultValue = "1") @ApiParam(value = "页号",required = true) Integer pageNum,
                               @RequestParam(defaultValue = "5") @ApiParam(value = "页的大小",required = true) Integer pageSize){
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(keyword))
            queryWrapper.eq("name",keyword); //精确查找 如果需要模糊查询  eq换成like即可
        Page page = new Page(pageNum,pageSize);
        roleService.page(page,queryWrapper);
        return new ResponseResult(200,"查询成功",page);

    }
    @PostMapping("/allocMenu")
    @ApiOperation("给角色分配菜单")
    public ResponseResult allocMenu(@RequestParam @ApiParam(value = "角色ID",required = true) Long roleId,
                                    @RequestParam @ApiParam(value = "菜单ID列表",required = true) String menuIds){
        roleService.allocMenu(roleId,menuIds);
        return new ResponseResult(200,"执行成功");
    }


}
