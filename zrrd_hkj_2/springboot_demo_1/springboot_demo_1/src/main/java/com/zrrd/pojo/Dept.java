package com.zrrd.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component // 将spring对象交给容器
@PropertySource(value = "classpath:/dept.properties",encoding = "UTF-8") // 加载指定配置文件
@Data //Data 是lombok使用最多的 自动生成 get/set/toString/equals/hashcode等方法
@NoArgsConstructor//无参构造
@AllArgsConstructor//全参构造
@Accessors(chain = true)//重写set方法，返回this对象
public class Dept {
    // spel表达式
    @Value("${dept.id}")
    private Integer id;
    @Value("${dept.name}")
    private String name;

    @Value("${dept.id2}")
    private Integer id2;
    @Value("${dept.name2}")
    private String name2;


}
