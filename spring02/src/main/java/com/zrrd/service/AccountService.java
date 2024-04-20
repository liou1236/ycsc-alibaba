package com.zrrd.service;

import com.zrrd.pojo.Account;

import java.util.List;

public interface AccountService {
    //    查询所有账户
    List<Account> findAll();

    //    根据id查询账户
    Account findById(Integer id);

    //    保存
    void  save(Account account);
    //    更新
    void update(Account account);
    //    删除
    void delete(Integer id);
}
