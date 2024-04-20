package com.zrrd;

import com.zrrd.dao.UserMapper;
import com.zrrd.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

public class MyTest {
    public static void main(String[] args) throws IOException {
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("sqlMapConfig.xml"));
        SqlSession sqlSession = build.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setAge(17);
        user.setName("张");
        List<User> byCondition = mapper.findByCondition(user);
        for (User u: byCondition) {
            System.out.println("user  = " + u);
        }
        sqlSession.close();
    }

}
