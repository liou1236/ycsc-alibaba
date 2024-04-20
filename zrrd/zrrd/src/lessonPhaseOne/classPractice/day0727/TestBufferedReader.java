package lessonPhaseOne.classPractice.day0727;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class TestBufferedReader {

    public static void main(String[] args) throws Exception{
        Reader reader = new BufferedReader(
                new FileReader("stream.txt"));
        String line = null;
        while (true){
            line = ((BufferedReader) reader).readLine();
            if (line == null)break;
            System.out.println(line);
        }
reader.close();
    }
}
