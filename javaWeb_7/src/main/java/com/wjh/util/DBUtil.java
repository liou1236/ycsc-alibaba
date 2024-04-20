package com.wjh.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBUtil {
    public Connection getConn(){
        Connection cn = null;
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://127.0.0.1:3306/test?useSSL=false&amp;characterEncoding=UTF-8";
        String username="root";
        String password="root";
        try {
            Class.forName(driver);
            cn = DriverManager.getConnection(url, username, password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return cn;
    }
}
