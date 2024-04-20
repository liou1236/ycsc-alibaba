package lessonPhaseOne.classPractice.day0807;

public class Test04 {

//        public static void main(String[] args) {
//            StringBuilder str = new StringBuilder("abc");
//            int result = getResult(str);
//            System.out.println(result);
//        }
//        public static int getResult(StringBuilder str){
//            str.append("abc");
//            str.delete(1,3);
//            System.out.println(str);
//            str.insert(0, "abc");
//            str.replace(0,3, "abc");
//            return str.length();
//        }
    private int x = 0;
    static int y = 1;
    protected int z = 2;
    short s = 128;
    boolean b1 = (10 > 4);

    public static void main(String[] args) {
        switch ((int) 3){
            case 1:
                System.out.println();break;
            case 2 :
                System.out.println();break;
        }
    }
    }
    class B extends Test04{
    void method(){
        int x = 1;
        int y = 2;
        int z = 3;
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
    }
    }

