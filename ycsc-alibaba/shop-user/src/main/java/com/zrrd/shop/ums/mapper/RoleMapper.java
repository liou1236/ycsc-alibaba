package com.zrrd.shop.ums.mapper;

import com.zrrd.shop.ums.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 后台用户角色表 Mapper 接口
 * </p>
 *
 * @author Ming
 * @since 2024-04-02
 */
public interface RoleMapper extends BaseMapper<Role> {
    /*
    * 删除某个管理员的以有角色
    * 根据管理员ID查询角色列表
    *  adminId   管理员id
    * */

    @Select("SELECT * FROM ums_role where id in (select role_id from ums_admin_role_relation where admin_id = #{param1})")
    List<Role> selectListByAdminId(Long adminId);

    @Delete("DELETE FROM ums_admin_role_relation where admin_id = #{param1}")
    int deleteByAdminId(Long adminId);

    /**
     * 新增一个管理员和角色的关联
     * @param adminId  管理员ID
     * @param roleId    角色ID
     * @return
     */
    @Insert("INSERT INTO ums_admin_role_relation VALUE(NULL,#{param1},#{param2})")
    int insertAdminRoleRelation(Long adminId,Long roleId);


    /**
     * 删除某个角色对应的全部菜单关联关系
     * @param roleId  角色id
     * @return
     */
    @Delete("DELETE FROM ums_role_menu_relation where role_id = #{param1}")
    int deleteRoleMenuRelation(Long roleId);


    /**
     * 新增一条角色和菜单的关系
     * @param roleId    角色id
     * @param menuId    菜单id
     * @return
     */
    @Insert("INSERT INTO ums_role_menu_relation VALUE(NULL,#{param1},#{param2})")
    int insertRoleMenuRelation(Long roleId,Long menuId);



}
