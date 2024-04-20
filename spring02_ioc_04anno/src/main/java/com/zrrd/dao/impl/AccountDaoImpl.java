package com.zrrd.dao.impl;

import com.alibaba.druid.filter.AutoLoad;
import com.zrrd.dao.AccountDao;
import com.zrrd.pojo.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private QueryRunner queryRunner;

    @Override
    public List<Account> findAll() throws SQLException{
        String sql = "select * from account";
        return queryRunner.query(sql,new BeanListHandler<>(Account.class));
    }

    @Override
    public Account findById(int id) throws SQLException {
        String sql ="select  * from account where aid =?";
        return queryRunner.query(sql,new BeanHandler<>(Account.class),id);
    }


}
