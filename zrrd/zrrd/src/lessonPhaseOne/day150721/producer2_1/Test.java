package lessonPhaseOne.day150721.producer2_1;


public class Test {
    public static void main(String[] args) {
        Container container5 = new Container();

        new Thread(new Producer(container5),"Producer_1").start();
        new Thread(new Producer(container5),"Producer_2").start();

        new Thread(new Consumer(container5),"Consumer_1").start();
    }
}
