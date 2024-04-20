package com.zrrd.web;

import com.zrrd.service.AccountService;

import java.sql.SQLException;
import java.util.Scanner;

public class AccountWeb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入出钱人");
        String outName = scanner.nextLine();
        System.out.println("请输入收钱人");
        String inName = scanner.nextLine();

        System.out.println("请输入转账金额");
        double money = Double.parseDouble(scanner.next());

//        创建业务层对象
        AccountService accountService = new AccountService();
        try {
            accountService.transfer(outName,inName,money);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
