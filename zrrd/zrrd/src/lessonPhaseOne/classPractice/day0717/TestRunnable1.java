package lessonPhaseOne.classPractice.day0717;

public class TestRunnable1 implements Runnable{
    int i;
    @Override
    public void run() {
        for (;i < 50;i++){
            System.out.println(Thread.currentThread()
                    .getName() + " " + i);
        }

    }

    public static void main(String[] args) {
        for (int i = 0;i < 50;i++){
            System.out.println(Thread.currentThread()
                    .getName() + " " + i);


            if (i == 10){
                TestRunnable1 tr = new TestRunnable1();
                TestRunnable1 tr1 = new TestRunnable1();
                Thread thread = new Thread(tr);
                Thread thread1 = new Thread(tr);
                thread.start();
                thread1.start();
            }
        }
    }
}
