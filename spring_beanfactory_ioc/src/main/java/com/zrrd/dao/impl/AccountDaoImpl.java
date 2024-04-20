package com.zrrd.dao.impl;

import com.zrrd.dao.AccountDao;

public class AccountDaoImpl implements AccountDao {
    @Override
    public void saveAccount(){
        System.out.println("保存了账户");
    }
}
