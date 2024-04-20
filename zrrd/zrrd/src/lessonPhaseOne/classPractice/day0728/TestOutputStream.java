package lessonPhaseOne.classPractice.day0728;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class TestOutputStream {
    public static void main(String[] args) throws Exception {
copyFile("stream.txt","streamCopy.txt");
    }
    public static void copyFile(String srcPath,String destPath)throws Exception{
        InputStream is = new FileInputStream(srcPath);
        OutputStream os = new FileOutputStream(destPath);
        byte[] arr = new byte[1024];
        int len = 0;
        while ((len = is.read(arr)) != -1){
            os.write(arr,0,len);
        }
        os.close();
        is.close();

    }
}
