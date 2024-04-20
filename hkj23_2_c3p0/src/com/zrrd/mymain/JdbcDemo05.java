package com.zrrd.mymain;

import com.zrrd.util.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;


public class JdbcDemo05 {
    public static void main(String[] args) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JdbcUtils.ds);

        String sql = "select count(*) from category";

        Object l = queryRunner.query(sql,new ScalarHandler());

        System.out.println("l = " + l);


    }
}
