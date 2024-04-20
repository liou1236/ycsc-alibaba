package lessonPhaseOne.classPractice.day0807;

import java.io.*;

public class CopyBIO {
    public static void main(String[] args) throws IOException {
        String path0 = "stream.txt";
        String path1 = "newStream01.txt";
        copy(path0,path1);
    }
    public static void copy(String srcFile, String destFile) throws IOException {
        FileInputStream fis = new FileInputStream(srcFile);
        BufferedInputStream is = new BufferedInputStream(fis);

        byte[] arr = new byte[1024];

        FileOutputStream fos = new FileOutputStream(destFile);// 节点流
        BufferedOutputStream os = new BufferedOutputStream(fos);// 处理流
        int len;
        while ((len = is.read(arr)) != -1){
            os.write(arr,0,len);
        }

        is.close();
        os.close();
    }
}
