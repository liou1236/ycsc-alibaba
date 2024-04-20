package lessonPhaseOne.classPractice.day0719;

import java.util.ArrayList;
import java.util.List;

public class TestVolatile {
    public static void main(String[] args) {
        MyList myList = new MyList();
        Thread1 t1 =new Thread1( myList);
        t1.start();

        Thread2 t2 =new Thread2(myList);
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

class Thread1 extends Thread{
    MyList list;
    public Thread1(MyList myList){
        super();
        this.list = myList;
    }
    @Override
    public void run(){
        // 添加元素

            try {
                for (int i = 0; i < 10; i++) {
                    list.add(i + "");
                    System.out.println(getName() + " 添加了元素" + i);
                    Thread.sleep(1000);
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


class Thread2 extends Thread{
    MyList list;
    public Thread2(MyList myList){
        super();
        this.list = myList;
    }

    public void run(){
        while (true){

            if (list.size() == 5){
                System.out.println(getName() + " 轮询list的长度为：" + list.size());
                System.out.println("此线程可以退出");
                throw new RuntimeException();
            }
        }
    }
}