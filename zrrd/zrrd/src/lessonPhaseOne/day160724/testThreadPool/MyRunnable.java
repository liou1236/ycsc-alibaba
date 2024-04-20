package lessonPhaseOne.day160724.testThreadPool;

import java.util.Date;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()
        + " timea = " + new Date());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()
        + " timeb = " + new Date());
    }
}
