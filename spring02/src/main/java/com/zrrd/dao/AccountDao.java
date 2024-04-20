package com.zrrd.dao;

import com.zrrd.pojo.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountDao {

    List<Account> findAll() throws SQLException;
    Account findById(Integer id) throws SQLException;

    //    保存
    void  save(Account account) throws SQLException;
    //    更新
    void update(Account account) throws SQLException;
    //    删除
    void delete(Integer id) throws SQLException;

}
