package lessonPhaseOne.day110715;

import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("任务定时，每隔一段时间执行");
            }
        },0,1000);
    }
}
