package com.zrrd.mymain;

import com.zrrd.pojo.Category;
import com.zrrd.util.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class JdbcDemo04 {
    public static void main(String[] args) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JdbcUtils.ds);
        String sql="select * from category";
        Object[] params={};
        List<Category> query = queryRunner.query(sql, new BeanListHandler<>(Category.class));
        for (Category category : query) {
            System.out.println(params
                    + "category = " + category);
        }
    }
}
