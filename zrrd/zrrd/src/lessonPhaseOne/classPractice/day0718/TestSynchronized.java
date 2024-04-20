package lessonPhaseOne.classPractice.day0718;

public class TestSynchronized implements Runnable{
    @Override
    public void run() {
        synchronized (this){
            System.out.println("同步代码块 对象锁");
        }
        synchronized (TestSynchronized.class){
            System.out.println("同步代码块 类锁");
        }
    }
    public static synchronized void info(){
        System.out.println("同步方法 对象锁");
    }
    public static synchronized void infoStatic(){
        System.out.println("同步方法 类锁");
    }

    public static void main(String[] args) {
        TestSynchronized ts = new TestSynchronized();
        Thread t = new Thread(ts);
        t.run();
        info();
        infoStatic();
    }
}
