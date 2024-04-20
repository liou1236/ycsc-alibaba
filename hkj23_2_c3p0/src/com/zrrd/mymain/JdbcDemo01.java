package com.zrrd.mymain;


import com.mysql.cj.QueryResult;
import com.zrrd.util.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;

public class JdbcDemo01 {
    public static void main(String[] args) throws Exception{
        QueryRunner qr =  new QueryRunner(JdbcUtils.ds);
//        String sql ="insert into category values (?,?)";
//        Object[] params = {55,"测试55"};
//        int line = qr.update(sql,params);
//
//
//        System.out.println("line = " + line);

//        String sql02 = "update category set cid = ? ,cname =? where cid =? ,cname =?";
//        Object[] params02 = {77,"hfhh",55,"测试55"};
//        int line02 = qr.update(sql02,params02);
//        System.out.println(line02);

//        String sql03 = "update category where cid =?";
//        Object[] params03 = {88};

        String sql04 = "delete from category where cid =?";
        Object[] params04 = {88};
        int update = qr.update(sql04,params04);
        System.out.println("update = " + update);
    }
}
