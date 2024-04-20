package com.zrrd.service;

import com.zrrd.pojo.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();

    Account  findById(int id) ;
}
