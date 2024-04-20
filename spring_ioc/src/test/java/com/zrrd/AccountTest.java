package com.zrrd;
import com.zrrd.dao.AccountDao;
import com.zrrd.dao.impl.AccountDaoImpl;
import com.zrrd.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class AccountTest {
    @Test
    public void test() {
// 1.使用ApplicationContext接口 ， 可以获取 spring容器

        ApplicationContext ac
                = new
                ClassPathXmlApplicationContext("beans.xml");
        AccountService accountService =
                (AccountService) ac.getBean("accountService");
        System.out.println("accountService = " +
                accountService);
        AccountService accountService1 =
                (AccountService) ac.getBean("accountService");
        System.out.println("accountService1 = " +
                accountService1);
        System.out.println("==========================");
        AccountDao accountDao = (AccountDao)
                ac.getBean("accountDao");
        System.out.println("accountDao = " +
                accountDao);
        AccountDao accountDao1 = (AccountDao)
                ac.getBean("accountDao");
        System.out.println("accountDao1 = " +
                accountDao1);
/**
 多态回顾：
 1. 接口 对象名= new 类名();
 2. 类名 对象名= new 类名();
 例如 有一个接口 A 实现类有B C D E
 创建 B C D E 的对象；
 2. 创建了4个对象
 1. A a = new B();
 a=new C();
 */
//        AccountDao accountDao1 =new
//                AccountDaoImpl();
//        AccountDaoImpl accountDao2 =new
//                AccountDaoImpl();
    }
}
