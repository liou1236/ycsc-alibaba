package lessonPhaseOne.day120716;

import lessonPhaseOne.classPractice.day0714.Test;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock implements Runnable{

    int ticketsNum = 100;
    ReentrantLock lock =  new ReentrantLock();

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lock.lock();//

            if (ticketsNum <= 0){
                System.out.println("票买光了");
                return;
            }
            System.out.println(Thread.currentThread().getName()
            + " 出票" + ticketsNum);

            ticketsNum--;
            lock.lock();//
        }
    }

    public static void main(String[] args) {
        TestLock ticket = new TestLock();
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);

        t1.start();
        t2.start();
        t3.start();

    }
}
