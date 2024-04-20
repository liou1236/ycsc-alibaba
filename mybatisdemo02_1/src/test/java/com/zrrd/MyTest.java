package com.zrrd;

import com.zrrd.dao.UserMapper;
import com.zrrd.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyTest {

    public static void main(String[] args) throws IOException {

//      构建sqlSession工厂
        SqlSessionFactory sqlSessionFactory= new
                SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("sqlMapConfig.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
       //设置查询条件
//        User user = new User();
//        user.setName("张");
//        user.setAge(17);
//        List<User> byCondition = mapper.findByCondition(user);
//        for (User user1 : byCondition) {
//            System.out.println("user1 = " + user1);
//        }
//
//        User user1 = new User();
//        user1.setName("张张三");
//        user1.setId(1);
//        mapper.update(user1);

////        ArrayList<Integer> integers = new ArrayList<>();
//        int[] integers = {1,3};
////        integers.add(1);
////        integers.add(3);
//        int[] byCondition2 = mapper.findByCondition3(integers);
//        for (int user: byCondition2
//             ) {
//            System.out.println("user = " + user);
//        }

        User user = new User();
        user.setName("一");
        user.setAge(3);

        User user2 = new User();
        user2.setName("二");
        user2.setAge(34);

        User user3 = new User();
        user3.setName("三");
        user3.setAge(345);

        ArrayList<User> users = new ArrayList<>();
        users.add(user2);
        users.add(user);

        users.add(user3);
        mapper.insertList(users);

        sqlSession.close();
    }
}
