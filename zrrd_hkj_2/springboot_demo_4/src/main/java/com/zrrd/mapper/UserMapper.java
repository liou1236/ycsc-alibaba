package com.zrrd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zrrd.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
