package com.zrrd.shop.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//T工具类 作用是封装请i去的响应的结果
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult<T> {
    private Integer code;//响应的状态码
    private String message; //响应的消息文本
    private T data;//查询时将结果进行封装

    public ResponseResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
