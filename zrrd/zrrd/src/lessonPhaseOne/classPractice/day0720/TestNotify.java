package lessonPhaseOne.classPractice.day0720;

import java.util.ArrayList;
import java.util.List;

public class TestNotify {
    public static void main(String[] args) {
        Object obj = new Object();
        MyList list = new MyList();

        Thread1 t1 = new Thread1(list,obj);
        t1.start();
        Thread2 t2 = new Thread2(list,obj);
        t2.start();

    }
}

class MyList{
    private volatile List<String> list = new ArrayList<>();
    public void add(String str){
        list.add(str);
    }
    public int size(){
        return list.size();
    }
}
class Thread1 extends Thread {
    MyList list;


    Object obj;

    Thread1(MyList list, Object obj){
        this.obj = obj;
        this.list =list;
    }

    @Override
    public void run() {
        synchronized (obj) {
            if (list.size() < 5) {
                try {
                    System.out.println(getName() + "等待长度为5");
                    obj.wait();
                    System.out.println(getName() + "被唤醒");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
class Thread2 extends Thread {
    MyList list;

    Object obj;
    Thread2(MyList list, Object obj){
        this.obj = obj;
        this.list =list;
    }

    @Override
    public void run() {
        synchronized (obj) {
            for (int i = 0; i < 10; i++) {
                list.add(i + " ");
                System.out.println(getName() + "添加了元素" + i);
                if (list.size() == 5) {
                    obj.notify();
                    System.out.println(Thread.currentThread().getName() + "发出了通知");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}