package lessonPhaseOne.classPractice.day0808Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String,String> players = playerMap();
        System.out.println("请输入球员姓名");
        String name = sc.next();
        System.out.println(players.getOrDefault(name, "不存在该球员"));
    }
    public static HashMap<String,String> playerMap(){
        HashMap<String,String> players = new HashMap<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(new File(".\\src\\com\\rd\\student\\jike\\class2\\lihongming\\Exam\\player.txt")));){
            String str;
            while (true) {
                if((str =reader.readLine())==null){
                    break;
                }
                players.put(str.split("，")[0], str.split("，")[1]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return players;
    }
}