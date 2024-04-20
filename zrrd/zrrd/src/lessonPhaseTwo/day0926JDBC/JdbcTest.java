package lessonPhaseTwo.day0926JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcTest {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = JdbcUtils.getConnection();
        String sql = "select * from category where cid = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,"1");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int cid = resultSet.getInt("cid");
            String cname = resultSet.getString("cname");
            System.out.println(cid + "=" + cname);
        }
        JdbcUtils.closeResource(connection,preparedStatement,resultSet);
    }
}
