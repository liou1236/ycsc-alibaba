package lessonPhaseOne.classPractice.day0731;

import java.util.ArrayList;
import java.util.Scanner;

public class TestRandom1 {
    public static void main(String[] args) {
        String all = "郑成祥、王博、孙文卓、郑睿娴、王高博、李春泉、张睿、王星凯、柏云耀、高艺铭、周子贺、杜航、高晨曦、张思韬、孙昊、方周、郭佳宝、姜万里、李宏鸣、薛志鑫、王海鑫、夏银银、吴俊豪、王向阳、徐铭泽、张世煊、才雨鑫、孙国伟、秦嘉林、王岩博、石睿、杜雨坤、黄奕鸣、金洪宇、李鑫、王宇芳、苏岩";
        String[] allArr = all.split("、");

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入随机个数：");
        int n = scanner.nextInt();
        int len = allArr.length;

        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int random = (int)(Math.random() * len);
            if (list.contains(random)){
                System.out.println("已经随机过：" + random +allArr[random]);
                i--;
                continue;
            }
            list.add(random);
            System.out.println(allArr[random]);
        }
        System.out.println(list);

//        ArrayList<String> eleList1 = new ArrayList<>();
//
//        while (eleList1.size() < n) {
//            int random = (int) (Math.random() * len);
//            String ele = allArr[random];
//            if (!eleList1.contains(ele)) {
//                System.out.println("添加元素：" + ele);
//                eleList1.add(ele);
//            } else {
//                System.out.println("重复元素：" + ele);
//            }
//        }
//        System.out.println(eleList1);



    }
}
