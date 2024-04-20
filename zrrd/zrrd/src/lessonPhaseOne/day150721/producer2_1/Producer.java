package lessonPhaseOne.day150721.producer2_1;

import java.util.Random;

public class Producer implements Runnable{
    Container container;
    public Producer(Container container){
        this.container = container;
    }
    @Override
    public void run() {
        while (true){
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            container.put(new Random().nextInt(100));
        }
    }
}
