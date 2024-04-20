package com.zrrd;

import com.zrrd.pojo.Account;
import com.zrrd.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    AccountService accountService;

    @Before
    public void before() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("beans.xml");
        accountService = applicationContext.getBean(AccountService.class);
    }

    @Test
    public void findAll() {
        List<Account> all = accountService.findAll();
        for (Account account : all) {
            System.out.println("account = " + account);
        }
    }

    @Test
    public void findById() {
        Account account = accountService.findById(6);
        System.out.println("account = " + account);

    }

    @Test
    public void delete() {
        accountService.delete(7);

    }

    @Test
    public void update() {
        Account account=new Account();
        account.setAid(9);
        account.setName("压缩999999");
        account.setUserid(3);
        accountService.update(account);

    }

    @Test
    public void insert() {
        Account account =new Account();
        account.setAid(11);
        account.setName("卡特888888");
        account.setUserid(1);
        accountService.save(account);
    }
}
