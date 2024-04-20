package com.zrrd.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {
    // 创建一个c3p0的连接池对象，使用的是c3p0-config中的default-config标签中的参数
    public static DataSource ds = new ComboPooledDataSource();
    // 从池中拿一个连接
    public static Connection getConnection() throws SQLException{
        return ds.getConnection();
    }
// 释放资源
    public static void closeResource(Connection conn, Statement st, ResultSet rs) throws SQLException {
        if (rs !=null){
            rs.close();
        }
        if (conn !=null){
            conn.close();
        }
        if (st !=null){
            st.close();
        }
    }

}
