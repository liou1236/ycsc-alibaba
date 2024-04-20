package lessonPhaseOne.day030705;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("next数据为：");
//        if (scanner.hasNext()){
//            String str = scanner.next();
//            System.out.println(str);
//        }

        System.out.println("nextLine数据为：");
        if (scanner.hasNextLine()){
            String str = scanner.nextLine();
            System.out.println(str);
        }
        System.out.println("输入一个整数：");
        int c = scanner.nextInt();
        System.out.println("输入一个double类型的小数：");
        double d = scanner.nextDouble();
        System.out.println("输入一个float类型的小数：");
        float f = scanner.nextFloat();

        System.out.println(c);
        System.out.println(d);
        System.out.println(f);
    }
}
