package lessonPhaseTwo.day0926JDBC;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

public class JdbcDemo05SH {
    /*
    ScalarHandler
    处理单数据查询，结果集只有一个，一般用于聚合函数
     */
    public static void main(String[] args) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JdbcUtilsc3p0.ds);
        String sql = "select count(*) from category";
        Object l = queryRunner.query(sql,new ScalarHandler());
        System.out.println("l = " + l);
    }
}
