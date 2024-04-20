package com.zrrd.shop.ums.service;

import com.zrrd.shop.ums.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.awt.print.Book;
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
    /**
     * 返回某个管理员的角色列表
     * @param adminId  管理员ID
     * @return
     */
    List<Role> getListByAdminId(Long adminId);

    /**
     * 给管理员分配角色
     * @param adminId  管理员id
     * @param roleIds   角色id  1,2,3
     * @return
     */
    Boolean allocRole(Long adminId,String roleIds);

    /**
     * 给角色更新菜单列表
     * @param roleId  角色ID
     * @param menuIds   菜单id列表  1,2,3
     * @return
     */
    Boolean allocMenu(Long roleId,String menuIds);
}
