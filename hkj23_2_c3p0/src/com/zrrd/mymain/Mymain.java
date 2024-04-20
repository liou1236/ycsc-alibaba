package com.zrrd.mymain;

import com.zrrd.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Mymain {
    public static void main(String[] args) throws Exception{
        Connection connection = JdbcUtils.getConnection();
        String sql = "insert into category values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,"44");
        preparedStatement.setString(2,"测试44");
        int i = preparedStatement.executeUpdate();
        System.out.println(" 影响了：  " + i);



        JdbcUtils.closeResource(connection,preparedStatement,null);
    }
}
