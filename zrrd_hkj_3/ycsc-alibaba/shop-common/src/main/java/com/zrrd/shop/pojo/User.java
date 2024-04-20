package com.zrrd.shop.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @author : Ming
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer uid;//主键
    private String username;//用户名
    private String password;//密码
    private String telephone;//手机号
    private String nickName;//昵称
    private String email;//电子邮箱
    private Timestamp createTime;//创建时间
    private Timestamp loginTime;//最近登录时间
    private Integer status;//状态: 0-冻结 1-可用
    private String note;//备注
}