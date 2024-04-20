package com.wjh.dao.impl;

import com.wjh.dao.UserDao;
import com.wjh.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoImpl implements UserDao {
    @Override
    public ResultSet selectSQL() throws SQLException {
        ResultSet rs = null;
        DBUtil util = new DBUtil();
        Connection cn = util.getConn();
        Statement st = cn.createStatement();
        String sql="select * from user";
        rs = st.executeQuery(sql);
//        while (rs.next()){
//            String user = rs.getString("user");
//            String pw = rs.getString("password");
//            System.out.println("user=" + user + "pw=" + pw);
//        }
        return null;
    }
}
