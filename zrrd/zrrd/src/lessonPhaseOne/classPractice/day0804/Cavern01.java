package lessonPhaseOne.classPractice.day0804;

public class Cavern01 extends Thread{
    MyList list;
    Object obj = new Object();
    int crossedNum = 0;
    public Cavern01(MyList list, Object obj) {
        this.list = list;
        this.obj = obj;
    }

    @Override
    public void run() {

        synchronized (obj) {

            for (int i = 0; i < 10; i++) {
                crossedNum++;
                list.add(i+"");
                System.out.println(" " + Thread.currentThread().getName() +
                        " is pass，这是第" + crossedNum + "个用户");
                if (list.size() == crossedNum) {
                    obj.notify();
                    System.out.println(" 第" + crossedNum + "个用户已经通过");
                }
            }
        }
    }


    }
