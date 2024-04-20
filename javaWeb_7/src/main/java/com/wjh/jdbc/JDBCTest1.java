package com.wjh.jdbc;

import com.wjh.dao.UserDao;
import com.wjh.dao.impl.UserDaoImpl;

import java.sql.ResultSet;

public class JDBCTest1 {
    public static void main(String[] args) throws Exception {
        UserDao dao = new UserDaoImpl();
        ResultSet rs = dao.selectSQL();
        while (rs.next()){
            String user = rs.getString("user");
            String pw = rs.getString("password");
            System.out.println("user=" + user + "pw=" + pw);
        }
    }
}
