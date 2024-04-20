package com.zrrd.service;

import com.zrrd.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void insertUser(User user);


    void updateUser(User user);

    void deleteUserById(Integer id);
}
