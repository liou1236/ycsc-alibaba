package lessonPhaseOne.classPractice.day0731;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TestRandom4 {
    public static void main(String[] args) {
        String all = "郑成祥、王博、孙文卓、郑睿娴、王高博、李春泉、张睿、王星凯、柏云耀、高艺铭、周子贺、杜航、高晨曦、张思韬、孙昊、方周、郭佳宝、姜万里、李宏鸣、薛志鑫、王海鑫、夏银银、吴俊豪、王向阳、徐铭泽、张世煊、才雨鑫、孙国伟、秦嘉林、王岩博、石睿、杜雨坤、黄奕鸣、金洪宇、李鑫、王宇芳、苏岩";
        String[] allArr = all.split("、");

        ArrayList<String> allList = new ArrayList<>();
        for (int i = 0; i < allArr.length; i++) {
            allList.add(allArr[i]);
        }
        Collections.shuffle(allList);
        System.out.println(allList);

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入随机个数：");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(allList.get(i));
        }
    }
}
