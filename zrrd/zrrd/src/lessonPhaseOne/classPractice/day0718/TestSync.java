package lessonPhaseOne.classPractice.day0718;

public class TestSync implements Runnable{
    int ticketsNum = 100;

    Object obj = new Object();
    @Override
    public void run(){
        while (true) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (ticketsNum >= 0) {
                info();
            } else {
                break;
            }
        }
    }
    private synchronized int info(){

        if (ticketsNum <= 0){
            System.out.println("票卖光了");

        }
        System.out.println(Thread.currentThread().getName()
                + " 出票 " + ticketsNum);
        ticketsNum--;
        return ticketsNum;
    }
    public static void main(String[] args) {
        TestSync testSync = new TestSync();
        Thread t1 =new Thread(testSync);
        Thread t2 =new Thread(testSync);
        Thread t3 = new Thread(testSync);

        t3.start();
        t1.start();
        t2.start();
    }
}
