package lessonPhaseOne.day141021;

import com.mchange.lang.ShortUtils;

import java.util.ArrayList;
import java.util.List;

public class TestNotify {
    public static void main(String[] args) {
        Object obj = new Object();
        MyList list = new MyList();

        Thread1 t1 = new Thread1(list,obj);
        Thread2 t2 = new Thread2(list,obj);
        t1.start();
        t2.start();
    }


}
class MyList{
    private List<String> list = new ArrayList<>();
    public void add(String str){
        list.add(str);
    }
    public int size(){ return list.size();}


}
class Thread1 extends Thread{
    MyList list;
    Object obj;

    public Thread1(MyList list,Object obj){
        this.list = list;
        this.obj = obj;
    }
    @Override
    public void run(){
        synchronized (obj){
            if (list.size() < 5){
                System.out.println(getName() + "等待长度为5");
                System.out.println();
                try {
                    obj.wait();
                    System.out.println(getName() + "wait被唤起");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
class Thread2 extends Thread{
    MyList list;
    Object obj;

    public Thread2(MyList list,Object obj){
        this.list = list;
        this.obj = obj;
    }
    @Override
    public void run(){
        synchronized (obj){

                try {
                    for (int i = 0; i < 10; i++) {
                        list.add(i + "");
                        System.out.println(getName() + "添加了元素" + i);
                        if (list.size() == 5){
                            obj.notify();
                            System.out.println();
                            System.out.println(getName() + "发出了通知");
                            System.out.println();
                        }
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


