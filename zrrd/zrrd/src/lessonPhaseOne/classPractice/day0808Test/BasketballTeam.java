package lessonPhaseOne.classPractice.day0808Test;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class BasketballTeam {
    public static void main(String[] args) throws IOException {
        System.out.println("请输入球员名，找到队伍");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        HashMap<String,String> players = playMap();
//        if (players.containsKey(name)){
//            System.out.println(players.get(name));
//        }else {
//            System.out.println("没有该球员");
//        }
        System.out.println(players.getOrDefault(name,"没有该球员"));
    }
    public static HashMap<String, String> playMap() throws IOException {
        HashMap<String, String> players = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader("player.txt"));
        String str;
        while (true) {
            if ((str = reader.readLine()) == null) {
                break;
            }
            players.put(str.split("，")[0], str.split("，")[1]);
        }
        return players;
    }
}
