package com.zrrd.shop.service.impl;

        import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
        import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

        import com.zrrd.shop.dao.UserMapper;
        import com.zrrd.shop.pojo.User;
        import com.zrrd.shop.service.UserService;
        import org.springframework.security.crypto.bcrypt.BCrypt;
        import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Override
    public User login(String username, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        //唯一性 至多一条记录
        User user = (User) baseMapper.selectOne(queryWrapper);
        //spring工具类检查密码是否正确  密码明文：123456  user.getPassword() 查到的加密后的密码
        if (user != null && BCrypt.checkpw(password,user.getPassword())){
            return user;
        }
        return null;
    }
}
