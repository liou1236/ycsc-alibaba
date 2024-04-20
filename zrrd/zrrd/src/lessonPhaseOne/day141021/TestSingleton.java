package lessonPhaseOne.day141021;

import lessonPhaseOne.day020704.single.Singleton;
import lessonPhaseOne.day020704.single.Singleton2;

import java.security.PrivateKey;

public class TestSingleton {
//    private Singleton1(){}
//    private static Singleton1 instance;
//    public static Singleton1 getInstance(){
//        if (instance == null){
//            instance = new Singleton1();
//        }
//        return instance;
//    }
    private TestSingleton(){

    }
    private volatile static TestSingleton singleton;
//    public static synchronized TestSingleton getSingleton(){
//        if (singleton == null){
//            singleton = new TestSingleton();
//        }
//        return singleton;
//    }
    public static TestSingleton getInstance1(){
        if (singleton == null){
            synchronized (TestSingleton.class){
                singleton = new TestSingleton();
            }
        }
        return singleton;
    }
    public static TestSingleton getInstance(){
        if (singleton == null){
            synchronized (TestSingleton.class){
                if (singleton == null){
                    singleton = new TestSingleton();
                }
            }
        }
        return singleton;
    }
}
