package lessonPhaseOne.day150721.producer1;



public class Consumer implements Runnable {
    Container container;

    public Consumer(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Integer value = container.take();
        }
    }
}