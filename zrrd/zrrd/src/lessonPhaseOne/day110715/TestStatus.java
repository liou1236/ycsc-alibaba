package lessonPhaseOne.day110715;

public class TestStatus extends Thread{
    int i;
    @Override
    public void run(){
        for (; i < 50; i++) {
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        TestStatus ts = new TestStatus();
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName()
            + " " + i);
            if (i == 10){
                ts.start();
                System.out.println("线程存活状态：" + ts.isAlive());
            }
            if (i == 40){
                System.out.println("线程存货状态：" + ts.isAlive());
            }
        }
    }
}
