package com.zrrd.dao;

import com.zrrd.util.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.management.Query;
import java.sql.Connection;
import java.sql.SQLException;

public class Accountdao {
    public void out(String outName,double money) throws SQLException {
        // 获取链接
        Connection connection = JdbcUtils.getConnection();
        // 创建 queryrunner 对象执行SQL语句
        QueryRunner queryRunner = new QueryRunner();
        // 检查用户是否存在
        String sql01 = "select * from money where name = ?";

        Object query  = queryRunner.query(connection,sql01,new ScalarHandler(),outName);
        if (query == null){
            System.out.println("出钱用户不存在");
            System.out.println(1/0);
        }else {
            // 用户存在，准备SQL语句
            String sql02 = "update money set money=money- ? where name = ?";
            queryRunner.update(connection,sql02,money,outName);
//            queryRunner.update(connection,sql02,new ScalarHandler(),money,outName);
        }

    }

    public void in(String inName,double money) throws SQLException {
        // 获取连接
        Connection connection = JdbcUtils.getConnection();
        // 创建queryrunner 对象执行sql语句
        QueryRunner queryRunner = new QueryRunner();
        // 检查用户是否存在
        String sql03 = "select * from money where name = ?";
        Object query  = queryRunner.query(connection,sql03,new ScalarHandler(),inName);
        if (query == null){
            System.out.println("入钱用户不存在");
            System.out.println(1/0);
        }else {
            // 用户存在，准备sql语句
            String sql04 = "update money set money=money+? where name = ?";
            queryRunner.update(connection,sql04,money,inName);
        }

    }
}
