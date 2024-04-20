package lessonPhaseOne.day120716;

public class TestDaemon extends Thread{
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        TestDaemon daemon = new TestDaemon();
        daemon.setDaemon(true);
        System.out.println(daemon.isDaemon());
        daemon.start();
// 当所有非守护线程（主线程）结束时，守护线程也会随之结束，无论它是否已完成。
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()
            + " , " + i);
        }
    }
}
