package lessonPhaseOne.classPractice.day0717;

public class TestRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
    }

    public static void main(String[] args) {
        Runnable runnable = new TestRunnable();
        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(new TestRunnable());
        thread1.start();
        thread.start();
    }
}
