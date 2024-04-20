package com.zrrd.shop.ums.service;

import com.zrrd.shop.ums.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author Ming
 * @since 2024-04-02
 */
public interface IAdminService extends IService<Admin> {
    /**
     * 登陆方法
     * @param username
     * @param password
     * @return
     */
    Admin login(String username, String password);

    /**
     * 向一个Admin实例中添加权限信息  角色列表  有权访问的菜单列表
     * @param admin
     * @return
     */
    Admin permissionInfo(Admin admin);
}
