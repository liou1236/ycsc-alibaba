package lessonPhaseOne.classPractice.day0724;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class TestThreadPool {
    public static void main(String[] args) {
//        ExecutorService cachedThreadPool =
//                Executors.newCachedThreadPool();
//        for (int i = 0; i < 10;i++){
//
//            cachedThreadPool.execute(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                    System.out.println(Thread.currentThread().getName());
//                }
//            });
//        }
        fixedPool();
    }
    public static void fixedPool(){
        System.out.println("=============");
        ExecutorService fixedThreadPool =
                Executors.newFixedThreadPool(5);
        for (int i = 0; i < 11;i++){

            fixedThreadPool.execute(new Runnable() {
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
    public static void scheduledPool(){


    }
}

