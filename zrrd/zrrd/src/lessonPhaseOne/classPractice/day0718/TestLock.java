package lessonPhaseOne.classPractice.day0718;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock implements Runnable{
    int ticketsNum = 100;
    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run(){
        while (true){try{
            Thread.sleep(50);
        }catch (Exception e){
            e.printStackTrace();
        }
         lock.lock();

                if (ticketsNum <= 0){
                    System.out.println("票卖光了");
                    return;
                }
                System.out.println(Thread.currentThread().getName()
                        + " 出票 " + ticketsNum);
                ticketsNum--;
            }
        }

    public static void main(String[] args) {
        TestLock testTicket = new TestLock();
        Thread t1 =new Thread(testTicket);
        Thread t2 =new Thread(testTicket);
        Thread t3 = new Thread(testTicket);

        t3.start();
        t1.start();
        t2.start();
    }
}
