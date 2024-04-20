package com.zrrd.mymain;

import com.zrrd.util.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import java.sql.SQLException;
import java.util.List;

public class JdbcDemo06 {
    public static void main(String[] args) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JdbcUtils.ds);

        String sql = "select * from category";

        List<Object> cname = queryRunner.query(sql,new ColumnListHandler("cname"));
        System.out.println("cname = " + cname);
    }
}
