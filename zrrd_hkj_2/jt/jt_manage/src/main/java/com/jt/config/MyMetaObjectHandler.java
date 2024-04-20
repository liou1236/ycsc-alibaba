package com.jt.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Date date = new Date();
        this.setFieldValByName("create",date,metaObject);
        this.setFieldValByName("update",date,metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
    this.setFieldValByName("update",new Date(),metaObject);
    }
    //

}
