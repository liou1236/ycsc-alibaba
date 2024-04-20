package lessonPhaseOne.classPractice.day0731;

import java.util.*;

public class TestRandom3 {
    public static void main(String[] args) {
        String all = "郑成祥、王博、孙文卓、郑睿娴、王高博、李春泉、张睿、王星凯、柏云耀、高艺铭、周子贺、杜航、高晨曦、张思韬、孙昊、方周、郭佳宝、姜万里、李宏鸣、薛志鑫、王海鑫、夏银银、吴俊豪、王向阳、徐铭泽、张世煊、才雨鑫、孙国伟、秦嘉林、王岩博、石睿、杜雨坤、黄奕鸣、金洪宇、李鑫、王宇芳、苏岩";
        String[] allArr = all.split("、");

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入随机个数：");
        int n = scanner.nextInt();
        int len = allArr.length;

        HashSet<String> set = new HashSet<>();
        while (set.size() < n){
            int random = (int) (Math.random()*len);
            set.add(allArr[random]);
        }
        System.out.println(set);
        // 只通过hashset实现随机输出，尽管set是采用哈希表存储地址，再根据表中顺序输出并不与
        // 原添加顺序一致，每次存储的哈希算法不变，即存入表地址顺序不变，每次的输出顺序不改变，
        // 是一种“伪随机“，每次输出顺序不变且于输入顺序不同。
        // 采用LinkedHashSet可以在输出时保持与输入顺序一致
//        for (int i = 0; i < 3; i++) {
//            System.out.println("=============");
//            HashSet set1 = new HashSet();
//            set1.add("郑成祥");
//
//            set1.add("吴俊豪");
//
//            set1.add("孙昊");
//            Iterator iterator = set1.iterator();
//            while (iterator.hasNext()){
//                System.out.println(iterator.next());
//            }
//
//        }

    }
}
