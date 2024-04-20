package lessonPhaseOne.day0802;

public class Test03 {
    static  int i = 1;
    static {
        i++;
    }

    public static void main(String[] args) {
        increment(i,5);
        int c = increment(increment(i,5),5);
        System.out.println(c);
        pt(i);
        System.out.println("----------------");
        int i = 0;
        int count = 0;
        while (i++ < 2){
            count+=i;
        }
        System.out.println(count);

    }
    static int increment(int a,int b){
        a+=b;
        return a;
    }
    static void pt(int re){
        System.out.println(re);
    }
    static {
        i++;
    }
}
