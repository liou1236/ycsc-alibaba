package lessonPhaseOne.classPractice.day0807;

import java.io.*;

public class CopyBRW {
    public static void main(String[] args) throws IOException {
        String path0 = "stream.txt";
        String path1 = "newStream02.txt";
copy(path0,path1);
    }


    public static void copy(String srcFile,String destFile) throws IOException {
        Reader reader = new FileReader(srcFile);
        BufferedReader reader1 = new BufferedReader(reader);

        Writer writer = new FileWriter(destFile);
        BufferedWriter writer1 = new BufferedWriter(writer);

        char[] arr1 = new char[1024];
        while (  reader1.read(arr1) != -1){
            writer1.write(arr1);
        }
        reader1.close();
        writer1.close();
    }
}
