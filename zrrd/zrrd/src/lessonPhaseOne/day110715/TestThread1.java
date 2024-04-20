package lessonPhaseOne.day110715;

public class TestThread1 extends Thread{
    int i;
    @Override
    public void run(){
        for (; i < 50; i++) {
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() +
                    " " + i);

            if (i == 10){
                new TestThread1().start();
            }
            if (i == 30){
                new TestThread1().start();
            }
        }
    }
}
