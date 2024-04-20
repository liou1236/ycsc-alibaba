package com.zrrd.serviceImpl;

import com.zrrd.User;
import com.zrrd.service.UserService;
import org.apache.dubbo.config.annotation.Service;
// @service 引用的是dubbo包当中的service 而不是springboot中的service
//springboot中的service，只会在本地依赖注入  而dubbo中的service会将当前的实例注册到远程的zookeeper的注册中心里
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void insert() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("provider insert");
    }

    @Override
    public void update() {
        System.out.println("provider update");
    }

    @Override
    public void delete() {
        System.out.println("provider delete");
    }

    @Override
    public void select() {
        System.out.println("provider select");
    }

    @Override
    public User getUserById(Integer id) {
        return new User(1001,"tom");
    }
}
