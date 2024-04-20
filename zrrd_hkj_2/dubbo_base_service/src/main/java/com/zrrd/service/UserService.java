package com.zrrd.service;

import com.zrrd.User;

public interface UserService {
    void insert();
    void update();
    void delete();
    void select();
    User getUserById(Integer id);
}
