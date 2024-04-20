package lessonPhaseOne.classPractice.day0801;

import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        byte b1 = 1;
        byte b2 = 2;
        byte b3 =(byte) (b1 + b2);

        // b1 = b1 + b2;不可行
        b1 += b2;
        b1 += 1;

        // 非数字符号
        char c1 = '1';
        String s1 = "1";

        //int 4字节
        //boolean 1字节

        System.out.println(Character.isDefined(c1) +" "+
        Character.isDigit(c1) + " " +
        Character.isLetter(c1));

        char c2 = '\\';
        System.out.println(c2);

        int[] arr;
        arr = new int[50];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
        arr[i] = random.nextInt(50);
        }
        System.out.println(Arrays.toString(arr));
        // 猜7位彩票：1~35中随机前五位，1~12中随机后两位
            int[] arr1 = new int[35];
            int[] arr2 = new int[12];
            for (int i = 0;i < arr2.length;arr2[i] += ++i){}    // 数组二储存1~12
            for (int i = 0;i < arr1.length;arr1[i] += ++i){}    // 数组一储存1~35
            System.out.print("中奖彩票号码是：");
            for (int j = arr1.length - 1;j >= 0;j--){    // 乱序数组一
                int ran1 = new Random().nextInt(arr1.length);
                int temp = arr1[j];
                arr1[j] = arr1[ran1];
                arr1[ran1] = temp;
            }
            for (int j = 0;j < 5;j++){    // 打印前五位（已乱序）元素
                System.out.print(arr1[j]+" ");
            }
            for (int j = arr2.length - 1;j >= 0;j--){    // 乱序数组二
                int ran2 = new Random().nextInt(arr2.length);
                int temp = arr2[j];
                arr2[j] = arr1[ran2];
                arr2[ran2] = temp;
            }
            for (int j = 0;j < 2;j++){    // 打印后两位（已乱序）元素
                System.out.print(arr2[j]+" ");
            }
            char c3 = '\u0000';
            String s2 = "";
            int[] arr3 = {1,2,3,4,5,6,7,8,9};
        System.out.println();
        System.out.println(getMax(arr3));
        System.out.println(c3);
        System.out.println(s2);

        int[][][] arr5 =
        {
                {{1,2},{7,8}},
                {{3,4},{5,6}}
                };

                int[][][] threeDArray = {
                        {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                        {{10, 11, 12}, {13, 14, 15}, {16, 17, 18}},
                        {{19, 20, 21}, {22, 23, 24}, {25, 26, 27}}
                };

                // 使用三重嵌套循环打印三维数组的元素
                for (int i = 0; i < threeDArray.length; i++) {
                    for (int j = 0; j < threeDArray[i].length; j++) {
                        for (int k = 0; k < threeDArray[i][j].length; k++) {
                            System.out.print(threeDArray[i][j][k] + " ");
                        }
                        System.out.println(); // 换行
                    }
                    System.out.println(); // 两个三维数组之间换行
                }
            }

    public static int getMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];
        }
        return max;
    }
}
