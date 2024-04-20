package lessonPhaseOne.classPractice.day0804;

import java.util.Date;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()
                + " time = " + new Date());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()
                + " time = " + new Date());
    }
}

