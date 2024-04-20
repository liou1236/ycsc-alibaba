package practice.RandomMachine;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

public class RollCall {
    // 编写一个随机器，先通过字符串或集合读取班级所有同学的名字，然后根据输入的个数n，随机出不重复的n个同学。


    public static void main(String[] args) throws Exception{
        String[] roll1  = {"郑成祥","王博","孙文卓","郑睿娴","王高博","李春泉","张睿","王星凯","柏云耀",
                "高艺铭","周子贺","杜航","高晨曦","张思韬","孙昊","方周","郭佳宝","姜万里","李宏鸣","薛志鑫",
                "王海鑫","夏银银","吴俊豪","王向阳","徐铭泽","张世煊","才雨鑫","孙国伟","秦嘉林","王岩博",
                "石睿","杜雨坤","黄奕鸣","洪宇","李鑫","王宇芳","苏岩"};
//        List<String> roll = new ArrayList<>(Arrays.asList(roll1));

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入读取同学的个数：");
        int n = scanner.nextInt();
//        System.out.println(roll);
        Set<String> randomClassRoll = new HashSet<>();
        Random random = new Random();

        while (randomClassRoll.size() < n){
        int index = random.nextInt(roll1.length);
//        randomClassRoll.add(roll.get(index));
        randomClassRoll.add(roll1[index]);

        }
        
        System.out.println(Arrays.toString(randomClassRoll.toArray()));

        System.out.println("随机出的" + n + "个同学的名字是：");
        for (String name : randomClassRoll){
            System.out.println(name);
        }
    }
}
