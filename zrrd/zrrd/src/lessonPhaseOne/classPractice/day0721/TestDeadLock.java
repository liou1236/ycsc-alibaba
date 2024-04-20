package lessonPhaseOne.classPractice.day0721;

public class TestDeadLock {
    Object A = new Object();
    Object B = new Object();
    public void AtoB(){
        synchronized (A){
            synchronized (B){
                System.out.println(Thread.currentThread().getName() +
                        " A-->B");
            }
        }
    }
    public void BtoA(){
        synchronized (B){
            synchronized (A){
                System.out.println(Thread.currentThread().getName() +
                        " B-->A");
            }
        }
    }

    public static void main(String[] args) {
        TestDeadLock testDeadLock = new TestDeadLock();
        for (int i = 0;i < 100;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                   testDeadLock.AtoB();
                   testDeadLock.BtoA();
                }
            }).start();
        }
    }
}
