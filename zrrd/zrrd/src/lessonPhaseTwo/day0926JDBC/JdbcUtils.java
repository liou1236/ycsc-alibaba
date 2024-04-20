package lessonPhaseTwo.day0926JDBC;

import java.sql.*;

public class JdbcUtils {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/hkj_test?serverTimezone=Asia/Shanghai";
    private static String username = "root";
    private static String password = "root";
// 注册驱动
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    // 获取连接
    public static Connection getConnection() throws Exception{
        Connection connection = DriverManager.getConnection(url,username,password);
        return connection;
    }
    // 释放资源
    public static void closeResource(Connection conn, Statement st, ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (st != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (conn != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
