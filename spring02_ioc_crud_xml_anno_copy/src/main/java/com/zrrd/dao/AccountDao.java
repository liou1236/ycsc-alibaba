package com.zrrd.dao;

import com.zrrd.pojo.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountDao {
    List<Account> findAll() throws SQLException;
    Account  findById(int id) throws SQLException;
}
