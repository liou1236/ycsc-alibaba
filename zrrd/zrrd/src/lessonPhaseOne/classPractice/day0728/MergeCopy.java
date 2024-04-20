package lessonPhaseOne.classPractice.day0728;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class MergeCopy {
    public static void main(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream("in.txt");
        System.setIn(fis);

        Scanner scanner = new Scanner(System.in);
        StringBuffer buffer = new StringBuffer();
        while (scanner.hasNext()){
            buffer.append(scanner.next() + "\n");
        }
        System.out.println(buffer);
        PrintStream ps = new PrintStream(
                new FileOutputStream("out.txt"));
        System.setOut(ps);

        System.out.println(buffer);
        ps.close();
        fis.close();

    }

}
