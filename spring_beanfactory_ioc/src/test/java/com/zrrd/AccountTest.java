package com.zrrd;

import com.zrrd.service.AccountService;
import com.zrrd.service.impl.AccountServiceImpl;
import org.junit.Test;

import java.sql.SQLOutput;

public class AccountTest{

    @Test
            public void saveAccount(){
        AccountService accountService = new AccountServiceImpl();
        accountService.saveAccount();
    }

}
