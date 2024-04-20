package lessonPhaseOne.day110715;

public class TestRunnable1 implements Runnable{
    int i = 0;
    @Override
    public void run() {
        for(; i < 50; i++) {
            System.out.println(Thread.currentThread().getName()
            + " " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            if (i == 10){
                TestRunnable1 tr = new TestRunnable1();
                Thread thread1 = new Thread(tr);
                thread1.start();

                TestRunnable1 tr2 = new TestRunnable1();
                Thread thread2 = new Thread(tr2);// tr为两个线程运行同一个i
                thread2.start();
            }
        }
    }
}
