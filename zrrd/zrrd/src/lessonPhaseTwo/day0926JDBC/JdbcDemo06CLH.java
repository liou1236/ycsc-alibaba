package lessonPhaseTwo.day0926JDBC;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import java.sql.SQLException;
import java.util.List;

public class JdbcDemo06CLH {
    public static void main(String[] args) throws SQLException {
        /*
        ColumnListHandler
        查询数据表中结果集的某一列数据，存储到list集合中
        不清楚哪一列，也不清楚类型List<Object>
         */
        QueryRunner queryRunner = new QueryRunner(JdbcUtilsc3p0.ds);
        String sql = "select * from category";
        List<Object> cname = queryRunner.query(sql,new ColumnListHandler("cname"));
        System.out.println("cname = " + cname);
    }
}
