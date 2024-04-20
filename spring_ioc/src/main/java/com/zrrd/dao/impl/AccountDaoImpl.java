package com.zrrd.dao.impl;

import com.zrrd.dao.AccountDao;

public class AccountDaoImpl implements AccountDao {
    @Override
    public void init() {
        System.out.println("我初始化");
    }

    @Override
    public void destroy() {
        System.out.println("我销毁");
    }


}
