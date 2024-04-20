package lessonPhaseOne.day110715;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class TestCallable1 implements Callable<Integer> {
//    @Override
//    public Integer call() throws Exception {
//        return null;
//    }
    @Override
    public Integer call() throws Exception{
        int sum = 0;
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName()
            + " " + i);
        }
        return sum;
    }

    public static void main(String[] args) throws Exception{
        TestCallable1 tc = new TestCallable1();
        FutureTask<Integer> task = new FutureTask<>(tc);
        Thread thread = new Thread(task);
        thread.start();
        System.out.println("线程启动：");

        Integer sum = task.get();
        System.out.println("Execution result:" + sum);
    }
}
