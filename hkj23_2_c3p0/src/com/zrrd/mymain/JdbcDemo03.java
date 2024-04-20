package com.zrrd.mymain;

import com.zrrd.pojo.Category;
import com.zrrd.util.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class JdbcDemo03 {
    public static void main(String[] args) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JdbcUtils.ds);
        String sql = "select * from category where cid =?";
        Object[] params = {55};
         Category category = queryRunner.query(sql,new BeanHandler<Category>(Category.class),params);
        System.out.println("category = " + category);
    }
}
