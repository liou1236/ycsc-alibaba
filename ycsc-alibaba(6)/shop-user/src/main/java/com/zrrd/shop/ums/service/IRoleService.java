package com.zrrd.shop.ums.service;

import com.zrrd.shop.ums.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 后台用户角色表 服务类
 * </p>
 *
 * @author Ming
 * @since 2024-04-02
 */
public interface IRoleService extends IService<Role> {


    //返回某个管理员的角色列表
    List<Role> getListByAdminId(Long adminId);

    //给管理员分配角色
    Boolean allocRole(Long adminId,String roleId);

    //给角色更新菜单列表
    /*
    roleId 角色id
    menuIds 菜单列表 1，2，3
     */
    Boolean allocMenu(Long roleId,String menuIds);
}
