package com.zrrd;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zrrd.mapper.DemoUserMapper;
import com.zrrd.pojo.DemoUser;
import org.apache.ibatis.annotations.Update;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootTest
@MapperScan("com.zrrd.mapper")
public class TestMP {
    @Autowired
    private DemoUserMapper userMapper;
    @Test
    public void insert(){
       DemoUser user = new DemoUser();
       user.setSex("男").setAge(12).setName("火男");
       userMapper.insert(user);
    }
    //测试更新操作 修改id=231的数据 name="" age=18 原则：根据对象不为空的属性当作set条件 set name=xxx
    //用byid id必须赋值 而且id当作唯一的where条件
    @Test
    public void updateById(){
        DemoUser user = new DemoUser();
        user.setName("晚上吃啥").setId(231).setAge(18);
        userMapper.updateById(user);
    }
    /*
    1.查询id=21的用户 根据id查询数据 1条数据
    2、查询name=“白骨精” sex=“女” 的用户 List数据
    知识点：
     */
    @Test
    public void testSelect(){
        //根据id查询
        DemoUser user = userMapper.selectById(21);
        System.out.println(user);
        //根据属性查询
        DemoUser user1 = new DemoUser();
        user1.setName("白骨精").setSex("女");
        //条件构造器 queryWrapper是sql中where后的条件
        QueryWrapper<DemoUser> queryWrapper = new QueryWrapper<>(user1);
        List<DemoUser> userList = userMapper.selectList(queryWrapper);
        System.out.println(userList);

    }
    //特殊字符：>gt <lt =eq >=ge <=le 默认连接 and
    //select * from demo_user where age > 18 and sex = "女"
    @Test
    public void testSelect2(){
        QueryWrapper<DemoUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age",18).eq("sex","女");
        List<DemoUser> userList = userMapper.selectList(queryWrapper);
        System.out.println(userList);
    }
    //like "%精%"  likeRight "精%"  likeLeft "%精"
    @Test
    public void testSelect3(){
        QueryWrapper<DemoUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("name","精");
        List<DemoUser> userList = userMapper.selectList(queryWrapper);
        System.out.println(userList);
    }
    //查询sex="女"  select * from demo_user where sex = "女" order by id desc;
    @Test
    public void testSelect4(){
        QueryWrapper<DemoUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sex","女").orderByDesc("id");
        List<DemoUser> userList = userMapper.selectList(queryWrapper);
        System.out.println(userList);
    }

    //查询id=1，3，5，7  select * from demo_user where id in(xx,xx);
    @Test
    public void testSelect5(){
        Integer[] ids = {1,3,5,7};
        List<Integer> list = Arrays.asList(ids);
        QueryWrapper<DemoUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id",list);
        List<DemoUser> userList = userMapper.selectList(queryWrapper);
        System.out.println(userList);
    }
    //根据name属性和age属性查询数据，又是某个数据为null，此时要求动态查询SQL
    //where name=xxx age > xx
    //伪SQL：select * from demo_user where name!=null name=null and age>xx;
    //StringUtils.hasLength(name)判断字符串是否有效
    //condition:内部编辑一个判断条件 返回true则拼接该字段，否则不拼接
    @Test
    public void testSelect6(){
        QueryWrapper<DemoUser> queryWrapper = new QueryWrapper<>();
        String name = "白骨精";
        int age = 18;
        queryWrapper.eq(StringUtils.hasLength(name),"name",name)
                .gt(age>0,"age",age);
        List<DemoUser> userList = userMapper.selectList(queryWrapper);
        System.out.println(userList);
    }
    //只查询第一列数据  q = null不需要where条件
    @Test
    public void testSelect7(){
        QueryWrapper<DemoUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sex","男");
        List<Object> objects = userMapper.selectObjs(queryWrapper);
        System.out.println(objects);
    }
    // 查询name|sex字段
    @Test
    public void testSelect8(){
        QueryWrapper<DemoUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name","sex");
        List<DemoUser> userList = userMapper.selectList(queryWrapper);
        System.out.println(userList);
    }
    @Test
    public void testSelect9(){
        QueryWrapper<DemoUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name","sex");
        List<Map<String,Object>> maps = userMapper.selectMaps(queryWrapper);
        System.out.println(maps);
    }
// 更新数据
    @Test
    public void testUpdate(){
        DemoUser user = new DemoUser();
        user.setSex("男").setName("晚上吃啥");
        UpdateWrapper<DemoUser> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("name","晚上吃啥");
        userMapper.update(user,userUpdateWrapper);

//        userUpdateWrapper.set("name","中午吃啥").set("sex","男").eq("name","晚上吃啥");
//        List<DemoUser> userList = userMapper.selectList(userUpdateWrapper);
//        System.out.println(userList);
//
//        QueryWrapper<DemoUser> queryWrapper = new QueryWrapper<>();
//        queryWrapper.select("name","sex");
    }
    @Test
    public void testDelete(){
        DemoUser user = new DemoUser();
        userMapper.deleteById(231);
    }
}
