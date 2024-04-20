package lessonPhaseOne.classPractice.day0721.producer1;

import java.util.Random;

public class Producer implements Runnable{
    Container container;
    public Producer(Container container){
        this.container = container;
    }
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            container.put(new Random().nextInt(100));
        }
    }
}
