package lessonPhaseOne.classPractice.day0731;

import java.util.Scanner;

public class TestRandom {
    public static void main(String[] args) {
        String all = "郑成祥、王博、孙文卓、郑睿娴、王高博、李春泉、张睿、王星凯、柏云耀、高艺铭、周子贺、杜航、高晨曦、张思韬、孙昊、方周、郭佳宝、姜万里、李宏鸣、薛志鑫、王海鑫、夏银银、吴俊豪、王向阳、徐铭泽、张世煊、才雨鑫、孙国伟、秦嘉林、王岩博、石睿、杜雨坤、黄奕鸣、金洪宇、李鑫、王宇芳、苏岩";
        String[] allArr = all.split("、");
//        for (int i = 0; i < allArr.length; i++) {
//            String s = allArr[i];
//            System.out.println(s);
//        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入随机个数：");
        int n = scanner.nextInt();
        int len = allArr.length;

        int[] indexArr = new int[len];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            // 随机的是数组中的索引位置
            int index = (int)(Math.random()*len);
            boolean flag = false;
            for (int j = 0;j < cnt;j++) {
                if (index == indexArr[j]) {
                    flag = true;
                    break;
                }

            }
            if (!flag){
                indexArr[cnt] = index;
                cnt++;
                System.out.println(allArr[index]);
            }
            if (flag){
                cnt--;
            }

        }

//        int[] indexArr1 = new int[len];
//        for (int i = 0; i < len; i++) {
//            indexArr1[i] = -1;
//        }
//
//
//        for (int i = 0; i < n; i++) {
//            int random = (int)(Math.random()*len);
//            if (indexArr1[random] == -1){
//                indexArr1[random] = random;
//                System.out.println(allArr[random]);
//                System.out.println(Arrays.toString(indexArr1));
//            }else {
//                i--;
//            }
//        }

    }
}
