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
    * 根据管理员ID查询角色列表
    *  adminId   管理员id
    * */

    @Select("SELECT * FROM ums_role where id in (select role_id from ums_admin_role_relation where admin_id = #{param1})")
    List<Role> selectListByAdminId(Long adminId);

    //删除某个管理员已有角色
    @Delete("delete from ums_admin_role_relation where admin_id = #{param1}")
    int deleteByAdminId(Long adminId);
    /*
    * 新增一个管理员和角色的关联
    * */
    @Insert("insert into ums_admin_role_relation value(NULL,#{param1},#{param2})")
    int insertAdminRoleRelation(Long admin,Long roleId);

    /**
     * 杀出某个角色对应的全部菜单关联关系
     * @param roleId
     * @return
     */
    @Delete("delete from ums_role_menu_relation where role_id = #{param1}")
    int deleteRoleMenuRelation(Long roleId);

    /**
     * 新增一条角色和菜单的关系
     * @param roleId
     * @param menuId
     * @return
     */
    @Insert("insert into ums_role_menu_relation value(NULL,#{param1},#{param2})")
    int insertRoleMenuRelation(Long roleId,Long menuId);


}
