package lessonPhaseOne.day150721.producer1;


public class Test {
    public static void main(String[] args) {
        Container container = new Container();
        new Thread(new Producer(container),"Producer_1").start();

        new Thread(new Consumer(container),"Consumer_1").start();
        new Thread(new Consumer(container),"Consumer_2").start();
        new Thread(new Consumer(container),"Consumer_3").start();
    }
}
