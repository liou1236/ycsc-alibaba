package lessonPhaseOne.classPractice.day0727;

import java.io.*;

public class TestBuffered {
    public static void main(String[] args) throws Exception{

//        File file = new File("stream.txt");
//        FileInputStream fis = new FileInputStream(file);
//        InputStream is = new BufferedInputStream(fis);
//        byte[] arr = new byte[(int) file.length()];
//        is.read(arr);
//        System.out.println(new String(arr));
//        is.close();
//        fis.close();
        copyFile("stream.txt","streamBuffer.txt");

    }
    public static void copyFile(String srcPath,String destPath)throws Exception{
        // 建立两个流:输入流和输出流
        InputStream is = new BufferedInputStream(new FileInputStream(srcPath));
        OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath));
        byte[] arr = new byte[1024];
        int len = 0;
        while ((len = is.read(arr)) != -1){
            os.write(arr);
        }
        os.flush();
        is.close();
        os.close();

    }
}
