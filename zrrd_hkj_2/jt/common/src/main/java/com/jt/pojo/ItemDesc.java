package com.jt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Ming
 * 时间 2023/8/6
 */
@TableName("item_desc")
@Data
@Accessors(chain = true)
public class ItemDesc extends BasePojo{
//@TableId(type = IdType.AUTO) 不写，因为使用的是item的id（在ItemServiceImpl的saveItem方法中）
    @TableId
    private Integer id;
    private String itemDesc;

}
