package com.zrrd.service.impl;

import com.zrrd.dao.AccountDao;
import com.zrrd.pojo.Account;
import com.zrrd.service.AccountService;
import org.apache.ibatis.annotations.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public List<Account> findAll() {
        try {
            return accountDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Account findById(int id) {
        try {
            return accountDao.findById(id);
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }
    }

