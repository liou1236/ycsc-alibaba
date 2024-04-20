package com.zrrd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zrrd.pojo.DemoUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper//将mapper接口交给Spring进行管理
public interface DemoUserMapper extends BaseMapper<DemoUser> {
    List<DemoUser> findAll();
    void insertUser(DemoUser user);
    void updateUser(@Param("nowName")String nowName,@Param("oldName")String oldName,@Param("sex")String sex);
}
