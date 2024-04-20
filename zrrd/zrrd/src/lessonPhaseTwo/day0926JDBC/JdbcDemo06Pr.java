package lessonPhaseTwo.day0926JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcDemo06Pr {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatementD = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();
            String username = "aaa";
            String pwd = "sadfalshdfj 'or' a '=' a";
            String sql = "select * from user where username = ? and password =?";
            preparedStatementD = connection.prepareStatement(sql);

            preparedStatementD.setString(1,username);
            preparedStatementD.setString(2,pwd);
            System.out.println(preparedStatementD);
            resultSet = preparedStatementD.executeQuery();

            if (resultSet.next()){
                System.out.println("登录成功");
            }else {
                System.out.println("没查到");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.closeResource(connection,preparedStatementD,resultSet);
        }
    }
}
