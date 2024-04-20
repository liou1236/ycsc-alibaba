package lessonPhaseOne.classPractice.day0720;

public class TestNotify1 {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable).start();
        new Thread(myRunnable).start();
        new Thread(myRunnable).start();
    }

}
class MyRunnable implements Runnable {
    int num = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notifyAll();
                if (num < 100) {
                    System.out.println(Thread.currentThread().getName()
                     + ": " + num);
                    num++;
                    try {
                        wait();
                        System.out.println(Thread.currentThread().getName() + "接受到了通知");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}