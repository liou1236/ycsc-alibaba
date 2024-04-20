package lessonPhaseOne.classPractice.day0717;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class TestCallable implements Callable<String> {
    // 线程的执行逻辑写在 call()方法中
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " is running");
        Thread.sleep(1000);
        return "hello callable";
    }

    public static void main(String[] args) throws  Exception{
        TestCallable tc = new TestCallable();
        FutureTask<String> task = new FutureTask<>(tc);
        Thread thread = new Thread(task);
        thread.start();
        System.out.print("启动线程:");

        String result = task.get();
        System.out.println("执行结果:"+result);

    }
}
