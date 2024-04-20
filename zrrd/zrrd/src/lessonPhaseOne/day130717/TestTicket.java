package lessonPhaseOne.day130717;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import java.util.concurrent.atomic.AtomicInteger;

public class TestTicket implements Runnable{
    volatile AtomicInteger ticketsNum = new AtomicInteger(100);
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
//            synchronized (obj) {
                if (ticketsNum.get() <= 0) {
                    System.out.println("票卖光了");
                    return;
                }
                System.out.println(Thread.currentThread().getName() +
                        "出票：" + ticketsNum.getAndDecrement());
//            }
            }
        }
    }

    public static void main(String[] args) {
        TestTicket ticket = new TestTicket();
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);
        Thread t4 = new Thread(ticket);
        Thread t5 = new Thread(ticket);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
