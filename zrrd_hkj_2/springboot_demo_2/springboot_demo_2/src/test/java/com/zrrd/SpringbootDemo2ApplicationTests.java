package com.zrrd;

import com.zrrd.mapper.DemoUserMapper;
import com.zrrd.pojo.DemoUser;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan("com.zrrd.mapper")//以后可以不需要再次写单个mapper注解
class SpringbootDemo2ApplicationTests {
    @Autowired
    private DemoUserMapper userMapper;

    @Test
    void contextLoads() {
        System.out.println(userMapper.findAll());
    }

    @Test
    public void testInsert(){
        DemoUser demoUser = new DemoUser();
        demoUser.setId(null).setName("mybatis信息").setAge(22).setSex("其他");
        userMapper.insertUser(demoUser);
    }

    @Test
    public void testUpdate(){
        String oldName = "mybatis信息";
        String nowName = "测试信息";
        String sex = "男";
        userMapper.updateUser(nowName,oldName,sex);
    }
    @Test
    public void testSelect(){
        List<DemoUser> demoUsers = userMapper.selectList(null);
        System.out.println(demoUsers);
    }
}
