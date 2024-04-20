package com.zrrd.pojo;

import com.zrrd.dao.AccountDao;

public class Account {
    private int aid;
    private String name;
    private int userid;



    public Account(){

}
public Account(int aid, String name, int userid) {
        this.aid = aid;
        this.name = name;
        this.userid = userid;
    }
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Account{" +
                "aid=" + aid +
                ", name='" + name + '\'' +
                ", userid=" + userid +
                '}';
    }
}
