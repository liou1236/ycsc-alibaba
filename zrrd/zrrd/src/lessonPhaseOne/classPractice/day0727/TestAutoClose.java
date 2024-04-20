package lessonPhaseOne.classPractice.day0727;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestAutoClose {
    // 自动关闭
    public static void main(String[] args) {
        testAutoClose();
    }
    public static void testAutoClose() {
        // 程序里打开的IO流不属于内存资源  垃圾回收机制无法回收
        // 所以需要手动关闭
        // 因为手动关闭流资源非常繁琐  又容易忘记
        // jdk7以后提供了一种自动关闭 IO流资源的机制
        try (InputStream is = new FileInputStream("stream.txt")) {
            int cnt = 0;
            while (true) {
                byte[] arr = new byte[28];
                int len = is.read(arr);
                if (len == -1) {
                    System.out.println();
                    System.out.println(cnt);
                    System.out.println("读取完成");
                    break;
                }
                String content = new String(arr);
                System.out.print(len + "--" + content);
                cnt++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
