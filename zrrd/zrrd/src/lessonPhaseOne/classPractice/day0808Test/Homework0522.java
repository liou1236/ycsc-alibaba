package lessonPhaseOne.classPractice.day0808Test;

import java.util.Random;
public class Homework0522 {
    // 猜7位彩票：1~35中随机前五位，1~12中随机后两位
    public static void main(String[] args) {
        for (int m = 0; m < 100; m++) {
            int[] arr1 = new int[35];
            int[] arr2 = new int[12];
            for (int i = 0;i < arr2.length;arr2[i] += ++i){}    // 数组二储存1~12
            for (int i = 0;i < arr1.length;arr1[i] += ++i){}    // 数组一储存1~35
            System.out.print("中奖彩票号码是：");
            for (int j = 0;j < 5;j++){    // 乱序数组一
                int ran1 = new Random().nextInt(arr1.length);
                int temp = arr1[j];
                arr1[j] = arr1[ran1];
                arr1[ran1] = temp;
            }
            for (int j = 0;j < 5;j++){    // 打印前五位（已乱序）元素
                System.out.print(arr1[j]+" ");
            }
            for (int j = 0;j < arr2.length;j++){    // 乱序数组二
                int ran2 = new Random().nextInt(arr2.length);
                int temp = arr2[j];
                arr2[j] = arr1[ran2];
                arr2[ran2] = temp;
            }
            for (int j = 0;j < 2;j++){    // 打印后两位（已乱序）元素
                System.out.print(arr2[j]+" ");
            }
            System.out.print("\n");
        }

        }

}
