package lessonPhaseOne.day120716;

import lessonPhaseOne.day010703.Test;

public class TestTicket implements Runnable{
    int ticketNum = 100;
    Object obj = new Object();
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj) {
                if (ticketNum <= 0) {
                    System.out.println("票卖光了");
                    return;
                }
                System.out.println(Thread.currentThread().getName()
                        + " 出票:" + ticketNum);
                ticketNum--;
            }
        }
    }

    public static void main(String[] args) {
        TestTicket ticket = new TestTicket();
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);
        Thread t4 = new Thread(ticket);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
