package lessonPhaseOne.classPractice.day0721.producer3;

import java.util.LinkedList;

public class Container {
    LinkedList<Integer> list = new LinkedList<>();
    int capacity = 10;
    public void put(int value){

        // 当容器满了  需要阻塞等待
        synchronized (this){
            while (list.size() == capacity){
                System.out.println("full,waiting");
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(value);
            System.out.println(Thread.currentThread().getName() + " put" + value);
            notifyAll();
        }

    }

    public Integer take(){
        Integer value = 0;
        synchronized (this){
            while (list.size() == 0){
                System.out.println("empty,waiting");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            value = list.poll();
            System.out.println(Thread.currentThread().getName() + " take" + value);
        }
        return null;
    }

}


