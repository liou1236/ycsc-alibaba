package com.zrrd.service.impl;

import com.zrrd.dao.AccountDao;
import com.zrrd.dao.impl.AccountDaoImpl;
import com.zrrd.service.AccountService;
//import com.zrrd.util.BeanFactory;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao = new AccountDaoImpl();
//private AccountDao accountDao = (AccountDao) BeanFactory.getBean("AccountDao");
    @Override
    public void saveAccount(){
//        accountDao.saveAccount();
    }
}
