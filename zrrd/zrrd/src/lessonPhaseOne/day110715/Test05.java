package lessonPhaseOne.day110715;

import java.util.LinkedList;

public class Test05 {
    public static void main(String[] args) {
        Container c = new Container();
        new Thread(new Producer(c)).start();
        new Thread(new Producer(c)).start();
        new Thread(new Consumer(c)).start();
        new Thread(new Consumer(c)).start();
        new Thread(new Producer(c)).start();
        new Thread(new Consumer(c)).start();
    }
}
/*
生产者消费者模型：使用wait,notify实现
创建四个类，容器类，生产者类，消费者类，测试类
容器类：包括添加方法，去除方法，以及提供一个容器（集合），其中需要注意的是，容器为空去出不了，容器满了，添加不了
生产者消费者类：调用添加\删除方法，在run方法里面
测试类：创建几个线程测试
 */
class Container{
    LinkedList<Integer> a = new LinkedList<Integer>();
    int max_value = 10;
    public void add(){
        synchronized(this){
            while(max_value==a.size()){
                System.out.println("add wait");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            a.add((int)(Math.random()*100));
            System.out.println(Thread.currentThread().getName()+" add true");
            notifyAll();
        }
    }
    public void des(){
        synchronized(this){
            while(a.size() == 0 || a == null){
                System.out.println("des wait");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            a.remove(a.get(0));
            System.out.println(Thread.currentThread().getName()+" des true");
            notifyAll();
        }
    }
}

class Producer implements Runnable{
    Container c;

    public Producer(Container c) {
        this.c = c;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            c.add();
            System.out.println("add ture");
        }
    }
}

class Consumer implements Runnable{
    Container c;

    public Consumer(Container c) {
        this.c = c;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            c.des();
            System.out.println("add ture");
        }
    }
}