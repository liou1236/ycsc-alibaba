package lessonPhaseOne.classPractice.day0718;

public class TestDaemon extends Thread{
    public void run(){
        for (int i = 0;i < 50;i++){
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        TestDaemon daemon = new TestDaemon();
        daemon.setDaemon(true);

        daemon.start();
        System.out.println(daemon.isDaemon());

        for (int i = 0;i < 10;i++){
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}
