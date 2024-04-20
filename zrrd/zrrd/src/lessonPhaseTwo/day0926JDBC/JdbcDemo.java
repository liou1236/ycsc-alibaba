package lessonPhaseTwo.day0926JDBC;

import java.sql.*;

public class JdbcDemo {
    /*  1.注册驱动
        2.获取连接
        3.获取要执行的sql语句
        4.执行sql语句，并返回结果
        5.处理结果
        6.释放资源
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 获取连接
        String url = "jdbc:mysql://localhost:3306/hkj_test?serverTimezone=Asia/Shanghai";
        Connection connection = DriverManager.getConnection(url,"root","root");
        //获取要执行的sql语句
        Statement statement = connection.createStatement();
        //执行sql语句，并返回结果
        ResultSet resultSet = statement.executeQuery("select * from category");
        //处理结果
        while (resultSet.next()){
            String cid = resultSet.getString("cid");
            String cname = resultSet.getString("cname");
            System.out.println(cid + " + " + cname);
        }
        // 释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
