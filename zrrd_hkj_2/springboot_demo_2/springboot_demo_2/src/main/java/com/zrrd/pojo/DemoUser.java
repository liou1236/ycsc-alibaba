package com.zrrd.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("demo_user")//如果没有添加注解属性值 默认以类型（DemoUser）当作表名demouser
public class DemoUser {
    @TableId(type = IdType.AUTO)

    //@TableId(type = IdType.ASSIGN_UUID)
    //UUID随机hash算法，几乎不重复
    private Integer id;
    //名称一致可以省略
    //@TableField(value = "name",exist = true)
    private String name;
    private Integer age;
    private String sex;
}
