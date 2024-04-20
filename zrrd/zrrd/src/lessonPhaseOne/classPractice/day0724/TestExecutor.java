package lessonPhaseOne.classPractice.day0724;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestExecutor {
    public static final int CORE_POOL_SIZE = 5;
    public static final int MAX_POOL_SIZE = 10;
    public static final int QUEUE_CAPACITY = 20;
    public static final long KEEP_ALIVE_TIME = 1L;
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.AbortPolicy()
        );

        for (int i = 0; i < 26; i++) {
            MyRuunable runnable = new MyRuunable();
            executor.execute(runnable);
        }
        executor.shutdown();
        System.out.println("over");

    }
}
