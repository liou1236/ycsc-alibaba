package lessonPhaseOne.classPractice.day0804;

public class TestDeadLock {
    Object A = new Object();
    Object B = new Object();
    Object C = new Object();
    public void AToBToC(){
        synchronized (A){
            synchronized (B){
                synchronized (C){
                    System.out.println(Thread.currentThread().getName()
                    + "A->B->C");
                }
            }
        }
    }
    public void BToAToC(){
        synchronized (B){
            synchronized (A){
                synchronized (C){
                    System.out.println(Thread.currentThread().getName()
                            + "B->A->C");
                }
            }
        }
    }
    public void AToCToB(){
        synchronized (A){
            synchronized (C){
                synchronized (B){
                    System.out.println(Thread.currentThread().getName()
                            + "A->C->B");
                }
            }
        }
    }
    public void BToCToA(){
        synchronized (B){
            synchronized (C){
                synchronized (A){
                    System.out.println(Thread.currentThread().getName()
                            + "B->C->A");
                }
            }
        }
    }
    public void CToAToB(){
        synchronized (C){
            synchronized (A){
                synchronized (B){
                    System.out.println(Thread.currentThread().getName()
                            + "C->A->B");
                }
            }
        }
    }
    public void CToBToA(){
        synchronized (C){
            synchronized (B){
                synchronized (A){
                    System.out.println(Thread.currentThread().getName()
                            + "C->B->A");
                }
            }
        }
    }

    public static void main(String[] args) {
        TestDeadLock testDeadLock = new TestDeadLock();
        for (int i = 0;i < 1000;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    testDeadLock.AToBToC();
                    testDeadLock.AToCToB();
                    testDeadLock.BToAToC();
//                    testDeadLock.BToCToA();
//                    testDeadLock.CToBToA();
//                    testDeadLock.CToAToB();
                }
            }).start();
        }
    }
}
