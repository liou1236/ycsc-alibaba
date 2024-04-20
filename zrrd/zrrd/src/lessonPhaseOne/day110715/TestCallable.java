package lessonPhaseOne.day110715;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class TestCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()
        + " is running");
        Thread.sleep(1500);
        return "hello callable";
    }
    public static void main(String[] args) throws Exception{
        TestCallable tc = new TestCallable();
        FutureTask<String> task = new FutureTask<>(tc);
        Thread thread1 = new Thread(task);
        thread1.start();
        System.out.println("启动线程");

        String result = task.get();
        System.out.println("执行结果：" + result);
    }
}
