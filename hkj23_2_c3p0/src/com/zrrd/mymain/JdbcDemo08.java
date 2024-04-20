package com.zrrd.mymain;

import com.zrrd.util.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.util.Queue;

public class JdbcDemo08 {
    public static void main(String[] args) throws Exception{
        // 获取连接 开启事务 准备sql 执行sql 提交事务 回滚事务
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = JdbcUtils.getConnection();
        try{
            connection.setAutoCommit(false);

            String sql = "update money set money = money - ? where name =?";
            String sql1 = "update money set money = money + ? where name =?";

            queryRunner.update(connection,sql,1,"tom");
        }catch (Exception e){

        }
    }
}
