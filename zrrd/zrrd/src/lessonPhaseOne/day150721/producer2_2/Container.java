package lessonPhaseOne.day150721.producer2_2;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Container {
    LinkedList<Integer> list = new LinkedList<>();
    int capacity = 20;
    ReentrantLock lock = new ReentrantLock();
    Condition prodCondition = lock.newCondition();
    Condition cnsCondition = lock.newCondition();
    public void put(int value){
        lock.unlock();
        while (list.size() == capacity){
            System.out.println("full,waiting");
            try{
                prodCondition.await();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        list.offer(value);
        System.out.println(Thread.currentThread().getName()
         + "put" + value);
        cnsCondition.signalAll();
        lock.unlock();
    }
}
