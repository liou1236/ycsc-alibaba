package com.jt.service;

import com.jt.vo.ImageVO;
import com.jt.vo.SysResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author : Ming
 */
@Service
@PropertySource("classpath:/properties/image.properties")
public class FileServiceImpl implements FileService {
    //为属性动态赋值 注解 @Value
    @Value("${image.localPathDir}")
    private String localPathDir;
    @Value("${image.localUrlPath}")
    private String localUrlPath;

    /*private String localPathDir = "D:/JT_IMAGE";
    private String localUrlPath = "http://image.jt.com";*/
    /*
    * 1.参数   已知条件
    * 2.干什么:   实现文件上传
    * 3.返回值  : ImageVo 有效返回
    *
    * 文件上传案例实现
    * 1.如何保证前端上传的数据是有效的
    * 1.1 校验文件的名称  是否为图片
    * 1.2 校验是否为恶意程序    1.jpg.木马
    * */
    @Override
    public ImageVO upload(MultipartFile file) throws IOException {
        //1.1校验是否为图片类型 abc.jpg  ABC.JPG  文件大小写
        String fileName = file.getOriginalFilename();
        //将所有的文件名称转化为小写
        fileName = fileName.toLowerCase();
        if (!fileName.matches("^.+\\.(jpg|png|gif)$")){
            return null;
        }
        //1.2 校验图片类型是否为木马   1.jpg.木马
        try {
            BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
            int width = bufferedImage.getWidth();
            int height = bufferedImage.getHeight();
            if (width==0||height==0){
                return null;
            }
        } catch (IOException e) {
            return null;
        }
        //2.目录结构
        //2.1实现分目录进行存储  可以以时间的维度进行分割  /yyyy/MM/dd
        String dataPath = new SimpleDateFormat("/yyyy/MM/dd/").format(new Date());
        //2.2进行目录的拼接 ""
        //2.2进行目录的拼接 "D:/JT_IMAGE/2024/1/11";
        String localDir = localPathDir + dataPath;
        //需要创建目录
        File dirFile = new File(localDir);
        if (!dirFile.exists()){
            dirFile.mkdirs();
        }
        //3.文件名称重复 采用UUID防止文件重名     UUID.jpg
        String uuid = UUID.randomUUID().toString().replace("-","");
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        String realFileName = uuid + fileType;
        String filePathAll = localDir + realFileName;
        //4.实现文件上传
        File realFile = new File(filePathAll);
        file.transferTo(realFile);
        //2024/01/11/uuid.jpg
        String virtualPath = dataPath + realFileName;
        //http://image.jt.com/2024/01/11/uuid.jpg
        String urlPath = localUrlPath + virtualPath;
        return new ImageVO(virtualPath,urlPath,realFileName);
    }
    //如果实现文件删除  virtualPath  2024/01/11/uuid.jpg
    @Override
    public void fileRemove(String virtualPth) {
        String filePath = localPathDir + virtualPth;
        File file = new File(filePath);
        //删除文件
        file.delete();
    }

}
