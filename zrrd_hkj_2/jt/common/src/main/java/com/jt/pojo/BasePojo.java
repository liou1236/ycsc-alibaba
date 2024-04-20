package com.jt.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
/**
 * @author Ming
 * 时间 2023/8/6
 */
//pojo基类，完成2个任务，2个日期，实现序列化
@Data
@Accessors(chain=true)
public class BasePojo implements Serializable{
	@TableField(fill = FieldFill.INSERT)
	private Date created;	//表示入库时需要赋值时的时间
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updated;	//表示入库/更新时赋值.
}
