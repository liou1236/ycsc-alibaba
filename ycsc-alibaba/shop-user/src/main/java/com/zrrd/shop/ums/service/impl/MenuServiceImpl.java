package com.zrrd.shop.ums.service.impl;

import com.zrrd.shop.ums.entity.Menu;
import com.zrrd.shop.ums.mapper.MenuMapper;
import com.zrrd.shop.ums.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 后台菜单表 服务实现类
 * </p>
 *
 * @author Ming
 * @since 2024-04-02
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Override
    public List<Menu> listByRoleId(Long roleId) {
        return baseMapper.selectListByRoleId(roleId);
    }
}
