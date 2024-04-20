package lessonPhaseOne.day160724.testThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestThreadPool {
    public static void main(String[] args) {
//        cachedPool();
//        fixedPool();
//        scheduledPool();
//        scheduledPool1();
//        scheduledPool2();
        singleExecutor();
    }

    public static void cachedPool() {
        ExecutorService cachedThreadPool =
                Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
    }

    public static void fixedPool() {
        ExecutorService fixedPool =
                Executors.newFixedThreadPool(5);
        for (int i = 0; i < 8; i++) {
            fixedPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
    }

    public static void scheduledPool() {
        ScheduledExecutorService scheduledThreadPool =
                Executors.newScheduledThreadPool(5);

        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟执行");
            }
        }, 2, TimeUnit.SECONDS);
    }
    public static void scheduledPool1(){
        ScheduledExecutorService scheduledThreadPool1 =
                Executors.newScheduledThreadPool(3);
        scheduledThreadPool1.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("定时执行");
            }
        },1,2,TimeUnit.SECONDS);
    }
    // scheduledAtFixedRate和scheduledWithFixedDelay,后者会考虑
    // 到任务执行时间,然后延迟指定时间
    public static void scheduledPool2(){
        ScheduledExecutorService scheduledThreadPool1 =
                Executors.newScheduledThreadPool(3);
        scheduledThreadPool1.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("定时执行");
            }
        },1,2,TimeUnit.SECONDS);
    }
    public static void singleExecutor(){
        ExecutorService singleThreadPool =
                Executors.newSingleThreadExecutor();
        for (int i = 0; i < 6; i++) {
            singleThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.print("A");
                }
            });
            singleThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.print("B");
                }
            });
            singleThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.print("C");
                }
            });
        }
        singleThreadPool.shutdown();
    }
}