package com.zrrd.mymain;

import com.zrrd.util.JdbcUtils;

import java.sql.Connection;
import java.sql.Statement;

public class JdbcDemo07 {
    public static void main(String[] args) throws Exception {
        Connection connection = JdbcUtils.getConnection();
        Statement statement = connection.createStatement();
        try{
            connection.setAutoCommit(false);
            String sql = "update money set money = money - 1 where name = 'tom'";
            statement.executeUpdate(sql);
            String sql1 = "update money set money = money + 1 where name = 'jerry'";
            statement.executeUpdate(sql1);

            connection.commit();
            System.out.println("恭喜转账一万元");
        }catch (Exception e){
            connection.rollback();
            System.out.println("转账失败了");
        }
    }
}
