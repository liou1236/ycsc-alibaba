package com.zrrd.shop.ums.mapper;

import com.zrrd.shop.ums.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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

}
