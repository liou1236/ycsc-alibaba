package lessonPhaseOne.classPractice.day0725;

import java.io.*;

public class TestCopy {
    public static void main(String[] args) throws Exception{
        File srcFile = new File("stream.txt");
        File destFile = new File("streamCopy.txt");
        copyFile(srcFile,destFile);
    }
    public static void copyFile(File srcFile,File destFile) throws  Exception{
        // 源文件是存在的 目标文件不一定存在
        if (!destFile.exists()){
            destFile.createNewFile();
        }
        // 先从源文件中读取数据 再将数据写入到目标文件中
        InputStream is = new FileInputStream(srcFile);
//        byte[] byteArr = new byte[(int)srcFile.length()];
        OutputStream os = new FileOutputStream(destFile);
        byte[] byteArr = new byte[1024];
        // 因为如果水流过多,内存处理不了,所以将1024作为每次分批的大小
        // 相当于一开一关之间,数据的大小是1024字节
        // 循环读取直到读取完全部数据
        // 对于read方法,本身返回的是读取数据的长度
        int len = 0;
        while ((len = is.read(byteArr)) != -1){

            os.write(byteArr,0,len);
        }
        is.read(byteArr);
//        String content = new String(byteArr);


//        byte[] byteArr1 = content.getBytes();


        is.close();
        os.close();
    }
}
