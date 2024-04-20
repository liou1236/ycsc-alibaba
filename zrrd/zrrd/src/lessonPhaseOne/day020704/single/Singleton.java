package lessonPhaseOne.day020704.single;

public class Singleton {
    // 饿汉模式
    private static  Singleton instance = new Singleton();
    private Singleton(){}
    public static Singleton getInstance(){

        return instance;
    }
}
