package lessonPhaseOne.classPractice.day0807;

import java.io.*;

public class CopyRW {
    public static void main(String[] args) throws Exception{
        File file = new File("stream.txt");
        Reader reader = new FileReader(file);
        char[] arr = new char[1024];


        File file1 = new File("newStream.txt");
        Writer writer = new FileWriter(file1);
        while (reader.read(arr) != -1){
            writer.write(arr,0,arr.length);
        }
        System.out.println(new String(arr));
        reader.close();
        writer.close();
    }
}
