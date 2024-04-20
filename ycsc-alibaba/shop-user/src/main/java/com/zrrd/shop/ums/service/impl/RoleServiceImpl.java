package com.zrrd.shop.ums.service.impl;

import com.zrrd.shop.ums.entity.Role;
import com.zrrd.shop.ums.mapper.RoleMapper;
import com.zrrd.shop.ums.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 后台用户角色表 服务实现类
 * </p>
 *
 * @author Ming
 * @since 2024-04-02
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Override
    public List<Role> getListByAdminId(Long adminId) {
        return baseMapper.selectListByAdminId(adminId);
    }

    @Override
    @Transactional  //让当前方法内所有的操作同属于一个事务
    public Boolean allocRole(Long adminId, String roleIds) {
        //1.先将原有的角色关系删除
        baseMapper.deleteByAdminId(adminId);
        if (StringUtils.isEmpty(roleIds)){//如果为roleids为null 或空字符串 则直接返回无需进行第二部
            return true;
        }
        //2.在分配新的角色关系
        String[] idsArray = roleIds.split(",");//1,2,3 => [1,2,3]
        for (String roleId : idsArray){
            baseMapper.insertAdminRoleRelation(adminId,Long.valueOf(roleId));
        }
        return true;
    }

    @Override
    @Transactional  //让当前方法内所有的操作同属于一个事务
    public Boolean allocMenu(Long roleId, String menuIds) {
        //1.先将原有的角色-菜单关系删除
        baseMapper.deleteRoleMenuRelation(roleId);
        if (StringUtils.isEmpty(menuIds)){
            return true;
        }
        //重新分配(角色-菜单) 关联关系
        for (String menuId : menuIds.split(",")){
            baseMapper.insertRoleMenuRelation(roleId,Long.valueOf(menuId));
        }
        return true;
    }


}
