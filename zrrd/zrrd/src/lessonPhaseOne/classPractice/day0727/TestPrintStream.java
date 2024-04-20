package lessonPhaseOne.classPractice.day0727;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class TestPrintStream {
    public static void main(String[] args) throws Exception{
//        File file = new File("in.txt");
//        file.createNewFile();
        FileInputStream fis = new FileInputStream("in.txt");

        System.setIn(fis);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            System.out.println(scanner.next());
        }
        fis.close();

       PrintStream ps = new PrintStream(
               new FileOutputStream("out.txt"));

       System.setOut(ps);

        System.out.println("hello out txt");
        ps.close();
    }
    public static void test()throws Exception{
        FileOutputStream fos = new FileOutputStream("streamPrint.txt");
        PrintStream ps = new PrintStream(fos);
        ps.println("hello printStream");

        ps.checkError();
        // 系统会自动关闭经处理流包装的节点流fos
        ps.close();
    }
    // 四种文件拷贝方式
}
