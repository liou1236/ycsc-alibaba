package lessonPhaseOne.classPractice.day0724;

import java.util.concurrent.Semaphore;

public class TestSemaphore {
    private static Semaphore semaphore =
            new Semaphore(20);

    public static void main(String[] args) {
        // 模拟50辆车进车出场景
        for (int i = 0; i < 50; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()
                     + " 来到停车场");
                    // 返回可用的令牌数量
                    if (semaphore.availablePermits() == 0){
                        System.out.println("车位不足，请等待");
                    }
                    try {
                        semaphore.acquire();
                        System.out.println("获取车位");
                        System.out.println(Thread.currentThread().getName()
                         + " 进入停车场");
                        Thread.sleep(3000);
                        System.out.println(Thread.currentThread().getName()
                         + " 开出停车场");
                        semaphore.release();
                        System.out.println("释放车位");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        thread.start();
        }

    }
}
