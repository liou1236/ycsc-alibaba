package lessonPhaseOne.classPractice.day0725;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TestOutputStream {
    public static void main(String[] args) throws IOException {
        File file = new File("stream.txt");
        file.createNewFile();

        String content = "hello stream";
        OutputStream os = new FileOutputStream(file);
        // 首先OutputStream是字节流 他写入文件所需要的是字节数组
        // 我们声明的是字符串 字符串也是由字节数组构成的
        // 可以将字符串转化为字节数组getBytes() 然后将字节数组传入到write()
        byte[] byteArr = content.getBytes();
        os.write(byteArr);
//        os.write(content.getBytes());
        // 创建Output Stream流的对象实时,相当于打开了一个水龙头
        // 在不断的用流的形式将数据写入后,要关闭水龙头,不然然是资源的浪费
        os.close();


    }
}
