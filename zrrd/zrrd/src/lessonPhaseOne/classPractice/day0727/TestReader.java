package lessonPhaseOne.classPractice.day0727;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class TestReader {
    public static void main(String[] args) throws Exception {
        File file = new File("stream.txt");
        Reader reader = new FileReader(file);
        char[] arr = new char[(int) file.length()];
        reader.read(arr);
        System.out.println(new String(arr));
        reader.close();

    }
}
