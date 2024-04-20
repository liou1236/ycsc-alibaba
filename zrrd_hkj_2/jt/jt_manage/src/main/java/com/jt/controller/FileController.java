package com.jt.controller;

import com.jt.service.FileService;
import com.jt.vo.ImageVO;
import com.jt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


/**
 * @author : Ming
 */
//1.获取其中的字节信息
//2.定义文件上传的位置,文件的名称
//3.循环遍历将字节信息依次输出
//4.关流
@RestController
@CrossOrigin
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    /*
    * Demo:
    * url: file:二进制信息
    * 返回值: SysResult对象
    * MultipartFile SpringMVC 对外提供一个接口 专门实现文件上传的操作
    * 高级Api  默认支持的大小  1M
    * 如果需要优化需要编辑配置类  重新定义大小
    * 优化: 1.防止文件重名
    *      2.防止恶意程序
    * */
    @PostMapping("/upload")
    public SysResult upload(MultipartFile file) throws IOException {
        ImageVO imageVO = fileService.upload(file);
        if (imageVO == null){
            return SysResult.fail();
        }
        return SysResult.success(imageVO);

       /* //1.获取文件名称
        String fileName = file.getOriginalFilename();
        //2.准备文件上传的本地目录
        String fileDir = "D:/JT_IMAGE";
        //3.需要判断目录是否存在
        File filePath = new File(fileDir);
        if (!filePath.exists()){
            //可以创建多级目录
            filePath.mkdirs();
            //只创建一级目录
            //filePath.mkdir();
        }
        //4.准备输出对象 文件的全路径="文件目录"/+"文件名称"
        String realFilePath = fileDir + fileName;
        File realFile = new File(realFilePath);
        //实现文件上传
        file.transferTo(realFile);
        return SysResult.success();*/
    }
    //实现文件的删除功能
    @DeleteMapping("/deleteFile")
    public SysResult fileRemove(String virtualPth){
        fileService.fileRemove(virtualPth);
        return SysResult.success();
    }
}
