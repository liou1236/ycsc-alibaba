package lessonPhaseOne.classPractice.day0719;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomic implements Runnable{
    AtomicInteger ticketsNum = new AtomicInteger(100);

    Object obj = new Object();

    @Override
    public void run(){
        while (true){try{
            Thread.sleep(500);
        }catch (Exception e){
            e.printStackTrace();
        }
            synchronized (obj){

                if (ticketsNum.get() <= 0){
                    System.out.println("票卖光了");
                    return;
                }
                System.out.println(Thread.currentThread().getName()
                        + " 出票 " + ticketsNum.getAndDecrement());
//                ticketsNum--;
            }
        }
    }
    public static void main(String[] args) {
        TestAtomic testTicket = new TestAtomic();
        Thread t1 =new Thread(testTicket);
        Thread t2 =new Thread(testTicket);
        Thread t3 = new Thread(testTicket);

        t3.start();
        t1.start();
        t2.start();
    }
}
