package com.zrrd.shop.ums.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 后台用户表
 * </p>
 *
 * @author hao
 * @since 2024-04-02
 */
@TableName("ums_admin")
@ApiModel(value = "Admin对象", description = "后台用户表")
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String username;

    private String password;

    @ApiModelProperty("头像")
    private String icon;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("备注信息")
    private String note;

    @ApiModelProperty(value = "创建时间",hidden = true)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "最后登录时间",hidden = true)
    private LocalDateTime loginTime;

    @ApiModelProperty("帐号启用状态：0->禁用；1->启用")
    private Integer status;

    @TableField(exist = false)//声明该变量没有存在ums_admin的栏位中
    private List<Menu> menus;

    @TableField(exist = false)//声明该变量没有存在ums_admin的栏位中
    private List<Role> roles;


    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", icon='" + icon + '\'' +
                ", email='" + email + '\'' +
                ", nickName='" + nickName + '\'' +
                ", note='" + note + '\'' +
                ", createTime=" + createTime +
                ", loginTime=" + loginTime +
                ", status=" + status +
                ", menus=" + menus +
                ", roles=" + roles +
                '}';
    }
}
