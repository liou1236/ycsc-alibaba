package lessonPhaseOne.classPractice.day0809;

import java.util.Scanner;

public class EncipheredData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("几位数：");
        int n = scanner.nextInt();
        int[] num = new int[n];
        System.out.println("请输入电话数字：");
        String str = scanner.next();


        System.out.print("第一步加上几：");
        int addNum = scanner.nextInt();

        System.out.print("第二步除以几：");
        int divNum = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            num[i] = (str.charAt(i) - '0');
        }
//        System.out.println(Arrays.toString(num));
        System.out.println("加密后：" + enciphered(num,addNum,divNum));
        System.out.println("原数字：" + decrypt(num,addNum,divNum));

    }
    public static String enciphered(int[] num,int addNum,int divNum){
        for (int i = 0; i < num.length; i++) {
            num[i]+=addNum;
            num[i]%=divNum;
        }
//        System.out.println(Arrays.toString(num));
        for (int j = 0; j < num.length/2; j++) {
            int temp = num[j];
            num[j] = num[num.length - 1 - j];
            num[num.length - 1 - j] = temp;
        }
        String strNum = "";
        for (int k = 0; k < num.length; k++) {
            strNum+=num[k] + " ";
        }
        return strNum;
    }
    public static String  decrypt(int[] num,int addNum,int divNum){
        for (int j = 0; j < num.length/2; j++) {
            int temp = num[j];
            num[j] = num[num.length - 1 - j];
            num[num.length - 1 - j] = temp;
        }
        for (int i = 0; i < num.length; i++) {
            if (num[i] > addNum){
                num[i]-=addNum;
            }else {
                num[i]+=divNum;
                num[i]-=addNum;
            }
        }
        String strNum = "";
        for (int k = 0; k < num.length; k++) {
            strNum+=num[k] + " ";
        }
        return strNum;
    }
}
