package lessonPhaseOne.day110715;

public class TestRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()
        + " is running");
    }
    public static void main(String[] args){
        Runnable runnable1 = new TestRunnable();
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(new TestRunnable());

        thread2.start();
        thread1.start();
    }
}
