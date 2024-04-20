package com.zrrd;

import com.zrrd.pojo.Dept;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
// 在执行测试方法时，自动启动spring容器
@SpringBootTest
class SpringbootDemo1ApplicationTests {
    @Autowired
private Dept dept;
    @Test
    void contextLoads() {
//        dept.setId(110).setName("玛卡巴卡");
        System.out.println(dept);
    }

}
