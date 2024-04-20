package lessonPhaseOne.classPractice.day0727;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestIn {
    public static void main(String[] args) throws Exception{
//        Scanner scanner = new Scanner(System.in);


        try(InputStream is = System.in){
        InputStreamReader reader = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(reader);

        String line = null;
        while (true) {
            line = br.readLine();
            if (line == null) break;
            if (line.equals("exit")) {
                System.exit(0);
            }
            System.out.println(line);
        }
        }

// 作业:添加自动关闭流
    }
}
