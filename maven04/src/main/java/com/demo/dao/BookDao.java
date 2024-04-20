package com.demo.dao;

import com.demo.pojo.Book;
import com.demo.util.DataSourceUtil;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class BookDao {
    /**
     * 查询所有图书
     * @return
     */
    public List<Book> findAll(){
        QueryRunner queryRunner = new QueryRunner(DataSourceUtil.getDataSource());

        String sql = "select * from book";
        try {
            return queryRunner.query(sql,new BeanListHandler<Book>(Book.class));
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}
