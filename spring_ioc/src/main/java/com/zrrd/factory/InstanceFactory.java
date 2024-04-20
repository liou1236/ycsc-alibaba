package com.zrrd.factory;

import com.zrrd.service.AccountService;
import com.zrrd.service.impl.AccountServiceImpl;

public class InstanceFactory {
    public AccountService getBean(){
        return new AccountServiceImpl();
    }
}
