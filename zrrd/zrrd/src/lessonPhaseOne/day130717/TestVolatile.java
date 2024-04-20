package lessonPhaseOne.day130717;

import java.util.ArrayList;
import java.util.List;

public class TestVolatile {


    public static void main(String[] args) {
        MyList myList = new MyList();
        Thread1 t1 = new Thread1(myList);
        t1.start();

        Thread2 t2 = new Thread2(myList);
        t2.start();

    }
}
class MyList{
    private List<String> list = new ArrayList<>();

    public void add(String str){
        list.add(str);
    }
    public int size(){
        return list.size();
    }
}
class Thread1 extends Thread{
    MyList list;
    public Thread1(MyList list){
        super();
        this.list = list;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                list.add(i + "");
                System.out.println(getName() + "添加了元素" + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
    class Thread2 extends Thread{
        volatile MyList list;
        public Thread2(MyList list){
            super();
            this.list = list;
        }
        @Override
        public void run(){
            while (true){
                if (list.size() == 5){
                    System.out.println("此线程可以退出");
                    throw new RuntimeException();
                }
            }
        }

}
