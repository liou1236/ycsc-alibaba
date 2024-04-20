package com.demo.dao;

import com.demo.pojo.User;
import com.demo.utils.DataSourceUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {
    public User login(String username, String password) throws SQLException {

        QueryRunner queryRunner = new QueryRunner(DataSourceUtil.getDataSource());
        String sql ="select * from user where username =?  and password =?";
        return queryRunner.query(sql,new BeanHandler<User>(User.class),username,password);
    }
}
