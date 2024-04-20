package lessonPhaseOne.day160724;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class TestSemaphore {
    private static Semaphore semaphore =
            new Semaphore(20);

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()
                     + " 来到停车场");
                    if (semaphore.availablePermits() == 0){
                        System.out.println("车位不足,请等待");
                    }
                    try {
                        long startTime = System.currentTimeMillis();
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName()
                         + " 进入停车场" + new Date());
                        Thread.sleep(new Random().nextInt(6666));
                        System.out.println(Thread.currentThread().getName()
                                + " 开出了停车场" + new Date());
                        semaphore.release();
                        long endTime = System.currentTimeMillis();
                        System.out.println(Thread.currentThread().getName()
                         + " 停留了" + (endTime - startTime) + "毫秒");
                        System.out.println();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            thread.start();
        }
    }
}
