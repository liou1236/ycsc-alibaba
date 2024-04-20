package com.zrrd.shop.ums.service;

import com.zrrd.shop.ums.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 后台菜单表 服务类
 * </p>
 *
 * @author Ming
 * @since 2024-04-02
 */
public interface IMenuService extends IService<Menu> {

        List<Menu> listByRoleId(Long roleId);

//        List<Menu> listByMenuId(Long menuId);

}
