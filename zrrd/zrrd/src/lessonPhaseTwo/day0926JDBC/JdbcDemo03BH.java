package lessonPhaseTwo.day0926JDBC;

import com.zrrd.pojo.Category;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class JdbcDemo03BH {
    /*
    BeanHandler
    将结果集中第一条记录封装到指定的javabean中

     BeanListHandler
     将结果集中每一条封装到List集合中
     */
    public static void main(String[] args) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JdbcUtilsc3p0.ds);
        String sql = "select * from category where cid = ?";
        Object[] params = {33};
        Category category = queryRunner.query(sql,new BeanHandler<>(Category.class),params);

        System.out.println("category = " + category);


    }
}
