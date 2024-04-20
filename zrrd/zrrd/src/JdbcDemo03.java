import lessonPhaseTwo.day0926Main.JDBCUtils;

import java.sql.*;

public class JdbcDemo03 {
    static Connection connection = null;
    static Statement statement = null;
    static ResultSet resultSet = null;
    static PreparedStatement preparedStatement = null;
    public static void main(String[] args) throws SQLException {
        try{
            connection = JDBCUtils.getConnection();
            String username = "aaa";
            String password = "bbb 'or' a '=' a";
            String sql = "select * from user where'username' = ? and 'password =?'";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString('2',password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                System.out.println("登录成功");
            }else {
                System.out.println("登录失败");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally{
            JDBCUtils.closeResource(connection,statement,resultSet);
        }
    }
}

