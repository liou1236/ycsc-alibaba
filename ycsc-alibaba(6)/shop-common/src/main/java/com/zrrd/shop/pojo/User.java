package com.zrrd.shop.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @author : Ming
 */
@TableName("t_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class User {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(name = "uid",value = "用户ID")
    private Integer uid;//主键
    @ApiModelProperty(name = "username",value = "用户登录名")
    private String username;//用户名
    @ApiModelProperty
    private String password;//密码
    @ApiModelProperty
    private String telephone;//手机号
    @ApiModelProperty
    private String nickName;//昵称
    @ApiModelProperty
    private String email;//电子邮箱
    @ApiModelProperty(hidden = true)
    private Timestamp createTime;//创建时间
    @ApiModelProperty(hidden = true)
    private Timestamp loginTime;//最近登录时间
    @ApiModelProperty
    private Integer status;//状态: 0-冻结 1-可用
    @ApiModelProperty
    private String note;//备注
}
