package lessonPhaseOne.day150721.producer2_1;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Container {
    LinkedList<Integer> list = new LinkedList<>();
    int capacity = 10;
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public void put(int value){
        lock.lock();
        while (list.size() == capacity){
            System.out.println("full,waiting");
            try{
                condition.await();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        list.offer(value);
        System.out.println(Thread.currentThread().getName()
                + " put" + value);
        condition.signalAll();
        lock.lock();
    }
    public Integer take() {
        Integer value = 0;
        lock.lock();
        while (list.size() == 0) {
            System.out.println("empty,waiting");

        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    value = list.poll();
        System.out.println(Thread.currentThread().getName()
        + " take" + value);
        condition.signalAll();
        lock.unlock();
        return value;
}

}
