package lessonPhaseTwo.day0926JDBC;

import com.zrrd.pojo.Category;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class JdbcDemo04BLH {
    public static void main(String[] args) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JdbcUtilsc3p0.ds);
        String sql = "select * from category";
        Object[] params = {};
        List<Category> query = queryRunner.query(sql,new BeanListHandler<>(Category.class));
        for (Category category :query) {
            System.out.println("category = " + category);
        }
    }
}
