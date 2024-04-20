package lessonPhaseOne.classPractice.day0804;


    import lessonPhaseOne.day160724.testThreadPool.MyRunnable;

    import java.util.concurrent.SynchronousQueue;
    import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

    public class TestExecutor {

        private static final int CORE_POOL_SIZE = 0;
        private static final int MAX_POOL_SIZE = Integer.MAX_VALUE;
        private static final int QUEUE_CAPACITY = 20;
        private static final Long KEEP_ALIVE_TIME = 1L;

        public static void main(String[] args) {
            // 最常使用的是第三个构造器  也就是没有线程工厂的
            ThreadPoolExecutor executor =
                    new ThreadPoolExecutor(
                            CORE_POOL_SIZE,
                            MAX_POOL_SIZE,
                            KEEP_ALIVE_TIME,
                            TimeUnit.SECONDS,
                            new SynchronousQueue<>(),
                            new ThreadPoolExecutor.AbortPolicy());

            for (int i = 0; i < 20; i++) {
                MyRunnable runnable = new MyRunnable();
                // 相当于 new Thread(runnable).start()
                executor.execute(runnable);
            }

//        // 终止
//        executor.shutdown();
//        System.out.println("finished");
        }
    }


