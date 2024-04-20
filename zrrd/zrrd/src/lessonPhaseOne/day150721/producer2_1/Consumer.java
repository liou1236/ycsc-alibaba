package lessonPhaseOne.day150721.producer2_1;

public class Consumer implements Runnable{
    Container container;
    public Consumer(Container container){
        this.container = container;
    }
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            container.take();
        }
    }
}
