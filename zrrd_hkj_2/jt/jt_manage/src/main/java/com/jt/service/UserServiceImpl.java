package com.jt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jt.mapper.UserMapper;
import com.jt.pojo.User;
import com.jt.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Ming
 * 时间 2023/8/6
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.selectList(null);
    }
    /*
    * user对象: username/password 用户传的明文
    * 业务思路:
    * 1.将密码进行加密处理 MD5加密方式
    * 2.根据新的用户名和密码查询数据
    * 3.结果: null 没查到 u/p错误 return null
    * 不为null u/p正确 返回令牌token(全球唯一的密钥)
    * UUID算法
    * MD5hash方式升级
    * 账号: admin 密码:admin123456
    * */
    @Override
    public String findUserByUP(User user) {
        //1.将密码进行加密 一般可以添加  盐值(由公司的域名构成)
        //hash(md5(www.baidu.com12345))
        String md5Pass = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        //2.根据用户名/密码进行查询数据库
        user.setPassword(md5Pass);
        //根据对象中不为null的属性当作where条件
        QueryWrapper queryWrapper = new QueryWrapper(user);
        User userDB = userMapper.selectOne(queryWrapper);
        //int a = 1/0;
        //3.返回密钥token
        String token = UUID.randomUUID().toString().replace("-","");
        return userDB==null?null:token;
    }
    /*
    * 业务说明: 将后台手机实现分页查询
    * 分页: sql: select * from user limit 起始位置,查询记录数
    * 查询第一页 每页20条
    * select * from user limit 0,20
    * Mp实现分页查询
    * */
    @Override
    public PageResult findUserByPage(PageResult pageResult) {
        //1.定义分页对象 2个参数
        IPage<User> page = new Page<>(pageResult.getPageNum(),pageResult.getPageSize());
        //2.定义查询条件
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //3.判断用户是否有参数
        boolean flag = StringUtils.hasLength(pageResult.getQuery());
        queryWrapper.like(flag,"username",pageResult.getQuery());
        page = userMapper.selectPage(page,queryWrapper);
        //4.获取总记录数
        long total = page.getTotal();
        //5.获取分页后的结果
        List<User> userList = page.getRecords();
        return pageResult.setTotal(total).setRows(userList);
    }

    @Override
    public void updateStatus(User user) {
        userMapper.updateById(user);
    }

    @Override
    public void addUser(User user) {
        //密码加密
        String md5Plus = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        //添加/修改必须带上时间
        user.setPassword(md5Plus).setStatus(true).setCreated(new Date()).setUpdated(user.getCreated());
        userMapper.insert(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        userMapper.deleteById(id);
    }
}
