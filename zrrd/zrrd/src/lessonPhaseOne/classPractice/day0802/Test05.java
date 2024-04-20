package lessonPhaseOne.day0802;

public class Test05 {
    int x;

    public static void main(String[] args) {
        Test05 test05 = new Test05();
        test05.x = 8;
        show(test05);
        System.out.println(test05.x);

        int a,b,c;
        a = 'a';
        b = 'b';
        c = (a+b>180?a++:b++);
        System.out.printf("%d %d %d",a,b,c);
        System.out.println();
        int x = 10;
        x = x++ + 10;
        System.out.println(x);
    }
    public static void show(Test05 test05){
        test05.x = 7;
    }
}
