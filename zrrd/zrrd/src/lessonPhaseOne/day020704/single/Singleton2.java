package lessonPhaseOne.day020704.single;

public class Singleton2 {
    private static class SingletonInner{
        private static final Singleton2 INSTANCE =
                new Singleton2();


    }
    public static Singleton2 getInstance(){

        return SingletonInner.INSTANCE;
    }
}
