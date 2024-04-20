package lessonPhaseOne.day010703;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        char c = '9';
        int d = c - '0';
        System.out.println(d);

        String str = "202";
        int strI = Integer.parseInt(str);
        System.out.println(strI);

        int i = 19;
        Integer integer = new Integer(i);
        int i1 = integer.intValue();

        Integer integer1 = 10;

        int i2 = integer1;

        System.out.println(Integer.SIZE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        // 包装类在通过方法值传递上不会改变（String不可变，其他引用类型会改变）
        Integer iii = 10;
        testInteger(iii);
        System.out.println(iii);

        String str1 = "safh";
        testString(str1);
        System.out.println(str1);

        int[] arr = new int[10];
        arr[0] = 3;
        testArr(arr);
        System.out.println(Arrays.toString(arr));

        int iiii = 10;
        testInt(iiii);
        System.out.println(iiii);

        Test.testInt(iiii);
        Test.testString(str1);

    }
    public static void testInteger(Integer integer){
        integer = 20;
    }
    public static void testInt(int inti){inti = 19;
        System.out.println(inti);}
    public static void testString(String str){
        str = "aaaa";
        System.out.println(str);
    }
    public static  void testArr(int[] arr){
        arr[0] = 8;
    }

}
