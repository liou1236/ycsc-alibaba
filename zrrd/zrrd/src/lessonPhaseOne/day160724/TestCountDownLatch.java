package lessonPhaseOne.day160724;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {
    private static CountDownLatch countDownLatch =
            new CountDownLatch(2);
    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()
                 + " countDown t1");
                countDownLatch.countDown();
                System.out.println("t1 finished");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()
                 + " countDown t2");
                countDownLatch.countDown();
                System.out.println("t2 finished");
            }
        });
        t1.start();
        t2.start();
        try {
            countDownLatch.await();
            long endTime = System.currentTimeMillis();
            System.out.println("执行间隔时间:" + (endTime - startTime));
            System.out.println("全部线程执行完成");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
