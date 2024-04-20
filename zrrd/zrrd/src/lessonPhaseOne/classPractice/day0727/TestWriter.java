package lessonPhaseOne.classPractice.day0727;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

public class TestWriter {
    public static void main(String[] args) throws Exception{
        File file = new File("streamNew.txt");
        Writer writer = new FileWriter(file);
        String content = "hello writer";
        writer.write(content);
        writer.close();
    }

}
