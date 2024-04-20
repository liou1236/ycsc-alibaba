package lessonPhaseOne.classPractice.day0725;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class TestInputStream {
    public static void main(String[] args) throws Exception{
        File file = new File("stream.txt");
        InputStream is = new FileInputStream(file);
        byte[] byteArr = new byte[(int)file.length()];
        is.read(byteArr);

        String content = new String(byteArr);
        System.out.println(content);

    }
}
