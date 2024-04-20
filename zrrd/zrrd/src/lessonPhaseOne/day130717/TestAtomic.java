package lessonPhaseOne.day130717;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomic implements Runnable {
    AtomicInteger ticketsNum = new AtomicInteger(100);

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (ticketsNum.get() <= 0){
                System.out.println("票卖光了");
                return;
            }
            System.out.println(Thread.currentThread().getName() +
                    " 出票：" + ticketsNum.getAndDecrement());
//            ticketsNum--;
        }
    }

    public static void main(String[] args) {
        TestAtomic ticket = new TestAtomic();
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);

        t1.start();
        t2.start();
        t3.start();
    }
}
