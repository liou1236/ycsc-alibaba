package com.zrrd.service;

import com.zrrd.dao.Accountdao;
import com.zrrd.util.JdbcUtils;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountService {
    public void transfer (String outName,String inName,double money) throws SQLException{
        Connection connection = JdbcUtils.getConnection();
        try{
            // 开启事务
            connection.setAutoCommit(false);
            // 创建dao对象
            Accountdao accountdao = new Accountdao();
            // 出钱
            accountdao.out(outName,money);
            // 取钱
            accountdao.in(inName,money);
            // 提交事务
            DbUtils.commitAndCloseQuietly(connection);
            System.out.println("转账成功");
        }catch (Exception e){
            e.printStackTrace();
            // 回滚事务
            DbUtils.rollbackAndCloseQuietly(connection);
            System.out.println("转账失败");
        }
    }
}
