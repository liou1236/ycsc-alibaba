package com.zrrd.service.impl;

import com.zrrd.dao.AccountDao;
import com.zrrd.pojo.Account;
import com.zrrd.service.AccountService;

import java.sql.SQLException;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao ;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

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
    public Account findById(Integer id) {
        try {
           return accountDao.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Account account) {
        try {
            accountDao.save(account);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Account account) {
        try {
            accountDao.update(account);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            accountDao.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
