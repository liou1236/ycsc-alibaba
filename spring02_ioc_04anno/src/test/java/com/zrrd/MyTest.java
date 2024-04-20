package com.zrrd;

import com.zrrd.pojo.Account;
import com.zrrd.service.AccountService;
import com.zrrd.spring.springConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MyTest {
    @Autowired
    private AccountService accountService;
    @Test
    public void findAll(){
//        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        AccountService accountService = (AccountService) ac.getBean("accountService");
//
//        List<Account> all = accountService.findAll();
//        for (Account account: all
//             ) {
//            System.out.println("account = " + account);
//        }
//        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(springConfig.class);
//        AccountService accountService = (AccountService) ac.getBean("accountService");
        List<Account> all = accountService.findAll();
        for (Account account: all
             ) {
            System.out.println("account = " + account);
        }


    }
    @Test
    public void findById(){
//        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        AccountService accountService = (AccountService) ac.getBean("accountService");
//
//        Account all = accountService.findById(9);
//        System.out.println("all = " + all);
    }
}
