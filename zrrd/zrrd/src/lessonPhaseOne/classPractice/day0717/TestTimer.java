package lessonPhaseOne.classPractice.day0717;

import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
    public static void main(String[] args) {
        // Timer
        Timer timer = new Timer();
        // TimerTask类其实实现了Runnable
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("定时任务，每隔一段时间执行一次");
            }
        },3000,1000);
        // 时间单位是毫秒
    }
}
