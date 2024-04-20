package lessonPhaseOne.classPractice.day0727;

import java.io.*;

public class TestConvert {
    public static void main(String[] args) throws Exception{
        // 字节流如何转化为字符流
        File file = new File("stream.txt");
        InputStream is = new FileInputStream("stream.txt");
        Reader reader = new InputStreamReader(is);//
        char[] arr = new char[(int) file.length()];
        reader.read(arr);
        System.out.println(new String(arr));

        reader.close();
        is.close();
    }
}
