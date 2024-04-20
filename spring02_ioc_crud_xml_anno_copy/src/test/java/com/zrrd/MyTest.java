package com.zrrd;

import com.zrrd.pojo.Account;
import com.zrrd.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void findAll(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = (AccountService) ac.getBean("accountService");

        List<Account> all = accountService.findAll();
        for (Account account: all
             ) {
            System.out.println("account = " + account);
        }

    }
    @Test
    public void findByid(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = (AccountService) ac.getBean("accountService");

        Account all = accountService.findById(9);
        System.out.println("all = " + all);
    }
}
