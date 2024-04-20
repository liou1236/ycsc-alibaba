package lessonPhaseOne.day020704;

public class Test {
    public static void main(String[] args) {
        double d = 345.678;
        String s = "你好";
        int i =123;
        System.out.printf("%f",d);
        System.out.println();
        System.out.printf("%2.2f",d);
        System.out.println();
        System.out.printf("%-9.3f",d);
        System.out.println();
        System.out.printf("%d",i);
        System.out.println();
        System.out.printf("%o",i);
        System.out.println();
        System.out.printf("%s",Integer.toBinaryString(i));
        System.out.println();
        System.out.printf("%x",i);
        System.out.println();
        System.out.printf("%#x",i);
        System.out.println();
        System.out.printf("%s",s);
        System.out.println();
        System.out.printf("输出一个浮点数：%f,一个整数：%d,一个字符串：%s",d,i,s);
    }
}
