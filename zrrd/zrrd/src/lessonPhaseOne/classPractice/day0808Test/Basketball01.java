package lessonPhaseOne.classPractice.day0808Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Basketball01 {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        BufferedReader reader = new BufferedReader(new FileReader("player.txt"));
        String str;
        while ((str = reader.readLine()) != null){
            String[] strName = str.split("，");
            String player = strName[0];
            String team = strName[1];
            if (name.equals(player)){
                System.out.println("所属球队为：" + team);
                reader.close();
                return;
            }
        }
        System.out.println("找不到该球员");
        reader.close();
    }


}
