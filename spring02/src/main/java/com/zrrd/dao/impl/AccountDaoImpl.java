package com.zrrd.dao.impl;

import com.zrrd.dao.AccountDao;
import com.zrrd.pojo.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
    private QueryRunner queryRunner;

    public void setQueryRunner(QueryRunner queryRunner){
        this.queryRunner = queryRunner;
    }
    @Override
    public List<Account> findAll() throws SQLException {
        String sql="select * from account";
        return queryRunner.query(sql,new BeanListHandler<>(Account.class));
    }

    @Override
    public Account findById(Integer aid) throws SQLException {
        System.out.println("id = " + aid);
        String sql = "select  * from account where aid = ? ";
        Object[] params={aid};
        return  queryRunner.query(sql, new BeanHandler<>(Account.class), params);
    }

    @Override
    public void save(Account account) throws SQLException {
        String sql = "insert into account  values (?,?,?)";
        Object[] params={account.getAid(),account.getName(),account.getUserid()};
        queryRunner.update(sql,params);
    }

    @Override
    public void update(Account account) throws SQLException {
        String sql ="update account set aid=? ,name=? ,userid=? where aid =?";
        Object[] params={account.getAid(),account.getName(),account.getUserid(),account.getAid()};
        queryRunner.update(sql,params);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        String sql ="delete from account where aid=?";
        queryRunner.update(sql,id);
    }
}
