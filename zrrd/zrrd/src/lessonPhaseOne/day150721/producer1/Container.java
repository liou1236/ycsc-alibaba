package lessonPhaseOne.day150721.producer1;

import java.util.LinkedList;

public class Container {
    LinkedList<Integer> list = new LinkedList<>();
    int capacity = 10;
    public void put(int value){
        synchronized (this){
            while (list.size() == capacity){
                System.out.println("full,waiting");
                try{
                    this.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            list.offer(value);
            System.out.println(Thread.currentThread().getName()
             + " put" + value);
            this.notifyAll();
        }
    }
    public Integer take(){
        Integer value = 0;
        synchronized (this){
            while (list.size() == 0){
                System.out.println("empty,waiting");
                try{
                    this.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            value = list.poll();
            System.out.println(Thread.currentThread().getName()
             + " take" + value);
            this.notifyAll();
        }
        return value;
    }
}
