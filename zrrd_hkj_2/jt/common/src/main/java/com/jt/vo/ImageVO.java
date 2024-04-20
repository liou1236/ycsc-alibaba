package com.jt.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class ImageVO {
    private String virtualPath; // 图片实际路径 不包含磁盘信息
    private String urlPath; // 图片访问路径
    private String fileName; //图片名称
}
