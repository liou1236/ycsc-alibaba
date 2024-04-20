package lessonPhaseOne.classPractice.day0804;

public class Cavern001 extends Thread{
    MyList list;
    Object obj = new Object();
    int crossedNum = 0;
    public Cavern001(MyList list, Object obj) {
        this.list = list;
        this.obj = obj;
    }
    @Override
    public void run() {

        synchronized (obj) {
            if (list.size() < 5) {
//                System.out.println(" " + Thread.currentThread().getName() +
//                        " is pass，这是第" + crossedNum + "个用户");
                try {
                    obj.wait();
                    System.out.println(" 第" + crossedNum++ + "个用户正在等待");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }


}
