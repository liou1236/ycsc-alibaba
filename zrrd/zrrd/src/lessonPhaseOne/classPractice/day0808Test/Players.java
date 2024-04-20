package lessonPhaseOne.classPractice.day0808Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Players {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入球员名字：");
        String name = scanner.next();

        BufferedReader playerRoll = new BufferedReader(new FileReader("player"));

        String strPlayer;
        boolean b1 = true;
        while ((strPlayer = playerRoll.readLine()) != null) {
            String[] arrPlayer;
            arrPlayer = strPlayer.split("，");
            if (arrPlayer[0].equals(name)) {
                System.out.println("该球员所处队伍：" + arrPlayer[1]);
                b1 = false;
            }
        }
        if (b1) {
            System.out.println("无该球员");
        }
        playerRoll.close();
    }
}
