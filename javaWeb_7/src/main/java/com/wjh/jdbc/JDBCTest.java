package com.wjh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {
    public static void main(String[] args) {
        String driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://127.0.0.1:3306/test?useSSL=false&amp;characterEncoding=UTF-8";
        String username="root";
        String password="root";
        try {
            Class.forName(driver);
            Connection cn = DriverManager.getConnection(url, username, password);
            Statement st = cn.createStatement();
            String sql="select * from user";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                String user = rs.getString("user");
                String pw = rs.getString("password");
                System.out.println("user=" + user + "pw=" + pw);
            }
            rs.close();
            st.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
