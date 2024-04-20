package com.zrrd.service.impl;

import com.zrrd.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public int inset(){
//        int i = 1/0;
        System.out.println("insert");
        return 0;
    }


    @Override
    public int update() {
        System.out.println("update");
        return 0;
    }

    @Override
    public int find() {
        System.out.println("find");
        return 0;
    }

    @Override
    public int delete() {
        System.out.println("delete");
        return 0;
    }
}
