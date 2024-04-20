package lessonPhaseOne.classPractice.day0721.producer1;

public class Test {
    public static void main(String[] args) {
        Container container = new Container();
        Producer producer1 = new Producer(container);
        Thread thread = new Thread(producer1);
        thread.start();

        new Thread(new Producer(container),"producer-1").start();
        new Thread(new Producer(container),"producer-2").start();
        new Thread(new Producer(container),"producer-3").start();

        Consumer consumer = new Consumer(container);
        Thread thread1 = new Thread(consumer);
        thread1.start();

        new Thread(new Consumer(container),"Container1").start();
        new Thread(new Consumer(container),"Container2").start();
        new Thread(new Consumer(container),"Container3").start();

    }
}
