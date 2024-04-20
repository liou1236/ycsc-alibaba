package com.zrrd.dao;

import com.zrrd.pojo.User;

import java.util.List;

/**
 * 用户的接口
 */
public interface UserMapper {
/**
 * 根据条件查询
 */
    List<User>  findByCondition (User user);

    void update(User user);

    List<User> findByCondition2(List<Integer> ids);

    List<User> findByCondition2(int[] ids);

    void insertList(List<User> users);

}
