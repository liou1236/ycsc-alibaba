package com.jt.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PageResult {
    private String query;//查询内容
    private Integer pageNum; //起始页
    private Integer pageSize;//每页条数
    private Long total;//总条数
    private Object rows;//分页结果
}
