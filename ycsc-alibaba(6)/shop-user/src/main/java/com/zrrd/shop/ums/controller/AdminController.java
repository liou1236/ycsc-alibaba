package com.zrrd.shop.ums.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrrd.shop.ums.entity.Admin;
import com.zrrd.shop.ums.service.IAdminService;
import com.zrrd.shop.ums.service.IRoleService;
import com.zrrd.shop.util.JwtUtil;
import com.zrrd.shop.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author Ming
 * @since 2024-04-02
 */
@RestController
@RequestMapping("/admin")
@Api(tags = "管理员信息接口列表")
public class AdminController {
    private IAdminService iAdminService;
    private IRoleService roleService;
    @Autowired
    public AdminController(IAdminService iAdminService, IRoleService roleService) {
        this.iAdminService = iAdminService;
        this.roleService = roleService;
    }
    @PostMapping("/delete/{id}")
    @ApiOperation("删除管理员")
    public ResponseResult delete(@PathVariable @ApiParam(value = "管理员ID",required = true) Integer id){
        iAdminService.removeById(id);
        return new ResponseResult(200,"删除成功");
    }
    @PostMapping(path = "/register",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("注册(创建)管理员")
    public ResponseResult register(@RequestBody Admin admin){
        admin.setPassword(BCrypt.hashpw(admin.getPassword(),BCrypt.gensalt()));
        admin.setCreateTime(LocalDateTime.now());
        iAdminService.save(admin);
        return new ResponseResult(200,"创建成功");
    }
    @PostMapping("/updateStatus/{id}")
    @ApiOperation("更新管理员账号状态")
    public ResponseResult updateStatus(@PathVariable Integer id,@RequestParam Integer status){
        UpdateWrapper<Admin> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",id);
        updateWrapper.set("status",status);
        iAdminService.update(updateWrapper);
        return new ResponseResult(200,"修改成功");
    }
    @PostMapping("/updatePassword/{id}")
    @ApiOperation("修改管理员密码")
    public ResponseResult updatePassword(@PathVariable @ApiParam(value = "管理员ID",required = true) Long id,
                                         @RequestParam @ApiParam(value = "旧密码",required = true)String oldPass,
                                         @RequestParam @ApiParam(value = "新密码",required = true)String newPass){
        //1.先验证旧密码是否正确
        Admin admin = iAdminService.getById(id);
        if (admin != null && BCrypt.checkpw(oldPass,admin.getPassword())){
            //2.更新密码
            UpdateWrapper<Admin> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("id",id);
            updateWrapper.set("password",BCrypt.hashpw(newPass,BCrypt.gensalt()));//将新密码加密后进行更新
            iAdminService.update(updateWrapper);
            return new ResponseResult(200,"修改成功");
        }else {
            return new ResponseResult(401,"旧密码校验错误,无法更新");
        }
    }
    @GetMapping("/list")
    @ApiOperation("分页查询管理员列表")
    public ResponseResult list(@RequestParam(required = false) @ApiParam(value = "姓名或者账号") String keyword,
                               @RequestParam(defaultValue = "1") @ApiParam(value = "页号",required = true) Integer pageNum,
                               @RequestParam(defaultValue = "10") @ApiParam(value = "页的大小",required = true) Integer pageSize){
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(keyword)){
            queryWrapper.eq("username",keyword)
                    .or()
                    .eq("nick_name",keyword);
        }
        Page<Admin> page = new Page<>(pageNum,pageSize);//补充分页信息
        iAdminService.page(page,queryWrapper);
        return new ResponseResult(200,"查询完成",page);
    }
    @PostMapping("/logout")
    @ApiOperation("管理员登出账号")
    public ResponseResult logout(@ApiIgnore HttpSession session){
        session.invalidate();//将当前会话清空
        return new ResponseResult(200,"登出成功");
    }
    @PostMapping("/login")
    @ApiOperation("管理员登录账号")
    public ResponseResult login(@RequestBody Admin admin){
        Admin user = iAdminService.login(admin.getUsername(),admin.getPassword());//完成登录验证
        if (user == null){//用户名或密码错误
            return new ResponseResult(401,"登录失败,用户名或密码错误");
        }else {//登陆成功, 生成jwt并返回
            Map<String,String> data = new HashMap<>();
            data.put("tokenHead","Bearer ");
            //令牌有效时间3个小时
            data.put("token", JwtUtil.create(3 * 60 * 60 * 1000,user.getId().toString(),user.getUsername()));
            return new ResponseResult(200,"登陆成功",data);

        }

    }
    @GetMapping("/info")
    @ApiOperation("获取当前管理员信息")
    public ResponseResult info(@RequestHeader("Authorization") @ApiParam(value =
            "登录令牌", required = true) String token) {
        System.out.println(token);
        String userinfo = JwtUtil.parse(token.split(" ")[1]);//return
        Admin admin = iAdminService.getById(userinfo.split(",")[0]);

        //注入管理员权限信息
        iAdminService.permissionInfo(admin);

        return new ResponseResult(200, "查询完成", admin);
    }

    @GetMapping("/role/{id}")
    @ApiOperation("查询某个管理员的角色列表")
    public ResponseResult getRole(@PathVariable @ApiParam(value = "管理员id")Long id){
        return new ResponseResult(200,"查询完成",roleService.getListByAdminId(id));
    }

    @PostMapping("/role/update")
    @ApiOperation("为管理员重新分配角色")
    public ResponseResult updateRole(@RequestParam @ApiParam(value = "管理员Id",required = true) Long adminId,
                                     @RequestParam @ApiParam(value = "角色Id列表",required = true,example = "1,2")String roleIds){
        roleService.allocRole(adminId,roleIds);//重新分配
        return new ResponseResult(200,"重新分配成功");
    }

}
