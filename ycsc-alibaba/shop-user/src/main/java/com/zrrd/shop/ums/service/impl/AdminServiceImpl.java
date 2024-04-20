package com.zrrd.shop.ums.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zrrd.shop.ums.entity.Admin;
import com.zrrd.shop.ums.mapper.AdminMapper;
import com.zrrd.shop.ums.mapper.MenuMapper;
import com.zrrd.shop.ums.mapper.RoleMapper;
import com.zrrd.shop.ums.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author Ming
 * @since 2024-04-02
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public Admin permissionInfo(Admin admin) {
        //分别调用menuMapper和 roleMapper 查询菜单和角色信息
        admin.setMenus(menuMapper.selectListByAdminId(admin.getId()));
        admin.setRoles(roleMapper.selectListByAdminId(admin.getId()));
        return admin;
    }
    @Override
    public Admin login(String username, String password) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        //因为用户名要保证唯一性,所以用户名当作条件至多查到一条数据
        Admin user = baseMapper.selectOne(queryWrapper);
        //判断用户名是否正确 & Spring工具类
        if (user != null && user.getStatus()==1 && BCrypt.checkpw(password,user.getPassword())){
            UpdateWrapper<Admin> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("id",user.getId());
            updateWrapper.set("login_time", LocalDateTime.now());//登录成功的时候更新最近登录时间
            update(updateWrapper);
            return user;//密码通过返回user
        }
        return null; //无论用户名或密码错误返回null
    }


}
