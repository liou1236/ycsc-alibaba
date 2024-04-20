package lessonPhaseOne.classPractice.day0724;

import java.util.Date;

public class MyRuunable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()
         + " time = " + new Date());

        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
