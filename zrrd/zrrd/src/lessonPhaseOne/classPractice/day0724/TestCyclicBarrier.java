package lessonPhaseOne.classPractice.day0724;

import java.util.concurrent.*;

public class TestCyclicBarrier {

    public static void main(String[] args) {
        ExecutorService service =
                Executors.newCachedThreadPool();
        CyclicBarrier cyclicBarrier =
                new CyclicBarrier(5, new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("全部到达，开始点餐");
                        service.shutdown();
                    }
                });

        for (int i = 0;i < 5;i++){
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName()
                         + " 到达饭馆");
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (BrokenBarrierException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
    }
}
