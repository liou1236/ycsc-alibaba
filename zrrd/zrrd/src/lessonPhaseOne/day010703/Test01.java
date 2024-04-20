package lessonPhaseOne.day010703;

import java.io.Serializable;

public class Test01 {
//    static void sayHello(char arg){
//        System.out.println("hello,char");
//    }
    static void sayHello(int arg){
        System.out.println("hello,int");
    }
    static void sayHello(long arg){
        System.out.println("hello,long");
    }
    static void sayHello(Character arg){
        System.out.println("hello,Character");
    }
    static void sayHello(Serializable arg){
        System.out.println("hello,Serializable");
    }
    static void sayHello(Comparable arg){
        System.out.println("hello,Comparable");
    }
    static void sayHello(Object arg){
        System.out.println("hello,object");
    }
    static void sayHello(char... arg){
        System.out.println("hello,char...");
    }

    public static void main(String[] args) {
        sayHello('a');
        Integer i1 = 10;
        Integer i2 = 10;
        System.out.println(i1 == i2);

        Integer i3 =190;
        Integer i4 =190;
        System.out.println(i3 == i4);

        Boolean b1 = true;
        Boolean b2 = true;
        System.out.println(b1 == b2);

        Long l1 = 100L;
        Long l2 = 100L;
        System.out.println(l1 == l2);

        Long l3 = 150L;
        Long l4 = 150L;
        System.out.println(l3 == l4);

        Character c1 = 48;
        Character c2 = 48;
        System.out.println(c1 == c2);

        Character c3 = 148;
        Character c4 = 148;
        System.out.println(c3 == c4);

        System.out.println("====================");
        System.out.println(Integer.compare(10,10));
        System.out.println(Integer.compare(10,20));
        System.out.println(Integer.compare(20,10));

        System.out.println(Character.isDigit('0'));
        System.out.println(Character.isDigit('a'));
        System.out.println("==============");

        System.out.println(Character.isLetter('a'));
        System.out.println(Character.isLetter('0'));
        System.out.println("===============");

        System.out.println(Character.toUpperCase('a'));
        System.out.println(Character.toLowerCase('A'));


    }

}
