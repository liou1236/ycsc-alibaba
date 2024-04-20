package com.zrrd.dao;

import com.zrrd.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> findByCondition(User user);
}
