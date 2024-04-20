package com.zrrd.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {
    public static DataSource ds = new ComboPooledDataSource();
    public static Connection getConnection() throws SQLException{
        return ds.getConnection();
    }

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
