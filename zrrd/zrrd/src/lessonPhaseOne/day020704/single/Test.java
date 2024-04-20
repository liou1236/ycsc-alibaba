package lessonPhaseOne.day020704.single;

public class Test {
    public static void main(String[] args) {
//        Singleton singleton = Singleton.getInstance();
//        Singleton singleton1 = Singleton.getInstance();
//        System.out.println(singleton == singleton1);
//
        Singleton1 singleton1 = Singleton1.getInstance();
        Singleton1 singleton2 = Singleton1.getInstance();
//        Singleton1 aa = new Singleton1();
        System.out.println(singleton1 == singleton2);

        Singleton2 singleton = Singleton2.getInstance();
        Singleton2 singleton4 = Singleton2.getInstance();
        System.out.println(singleton == singleton4);
//
//        Singleton3 singleton3 = Singleton3.INSTANCE;
//        Singleton3 singleton33 = Singleton3.INSTANCE;
//        System.out.println(singleton3 == singleton33);
    }
}
