package lessonPhaseOne.classPractice.day0727;

import java.io.FileInputStream;
import java.io.InputStream;

public class TestStream {
    public static void main(String[] args) throws Exception{
        InputStream is = new FileInputStream("stream.txt");
        int cnt = 0;
        while (true){
            byte[] arr = new byte[29];
            int len = is.read(arr,0,arr.length);
            if (len == -1){
                System.out.println();
                System.out.println(cnt);
                System.out.println("读取完成");
                break;
            }

            String content = new String(arr);
            System.out.print(len + "--" + content);
            cnt++;
        }
        is.close();
    }
}
