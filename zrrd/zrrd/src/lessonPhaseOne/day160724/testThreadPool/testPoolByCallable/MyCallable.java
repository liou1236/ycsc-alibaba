package lessonPhaseOne.day160724.testThreadPool.testPoolByCallable;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        Thread.sleep(1000);
        return Thread.currentThread().getName();
    }
}
