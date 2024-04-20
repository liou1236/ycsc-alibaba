package com.zrrd.dao.impl;

import com.zrrd.dao.CityDao;

public class CityDaoImpl implements CityDao {
    @Override
    public void delete(int b) {
        System.out.println("我删除了" + b);
    }
}
