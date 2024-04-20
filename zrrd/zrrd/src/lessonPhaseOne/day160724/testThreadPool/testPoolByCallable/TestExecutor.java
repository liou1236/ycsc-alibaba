package lessonPhaseOne.day160724.testThreadPool.testPoolByCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestExecutor {
    public static final int CORE_POOL_SIZE = 5;
    public static final int MAX_POOL_SIZE = 20;
    public static final int QUEUE_CAPACITY = 2;
    public static final long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );
        List<Future<String>> futureList = new ArrayList<>();
        MyCallable callable = new MyCallable();
        for (int i = 0; i < 12; i++) {
            Future<String> future = executor.submit(callable);
            futureList.add(future);
        }
        for (Future<String> future : futureList){
            try {
                String result = future.get();
                System.out.println(result);
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
