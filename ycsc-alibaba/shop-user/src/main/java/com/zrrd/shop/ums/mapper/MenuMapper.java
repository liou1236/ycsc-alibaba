package com.zrrd.shop.ums.mapper;

import com.zrrd.shop.ums.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 后台菜单表 Mapper 接口
 * </p>
 *
 * @author Ming
 * @since 2024-04-02
 */
public interface MenuMapper extends BaseMapper<Menu> {
    /*
    * 根据管理员ID查询(其有的权限访问的) 菜单列表
    * */
    @Select("SELECT * FROM ums_menu where id in " +
            "(select menu_id from ums_role_menu_relation where role_id in" +
            "(select role_id from ums_admin_role_relation where admin_id=#{param1}))")
    List<Menu> selectListByAdminId(Long adminId);

    /**
     * 使用角色id查询菜单列表
     * @param roleId  角色id
     * @return
     */
    @Select("SELECT * from ums_menu where id IN " +
            "(SELECT menu_id FROM ums_role_menu_relation where role_id = #{param1})")
    List<Menu> selectListByRoleId(Long roleId);

}
