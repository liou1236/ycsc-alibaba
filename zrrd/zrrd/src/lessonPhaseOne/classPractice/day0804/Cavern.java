package lessonPhaseOne.classPractice.day0804;

public class Cavern extends Thread{
    Object obj;
    public Cavern(){}
    public Cavern(Object obj){
        this.obj = obj;
    }
    int crossedNum;
    @Override
    public void run() {
        synchronized (obj) {
            try {
                crossedNum++;
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(" " + Thread.currentThread().getName()
                    + " is pass，这是第" + crossedNum + "个用户");
        }
    }
    public static void main(String[] args) throws InterruptedException {
//
        Object obj = new Object();
//        Cavern cave = new Cavern(obj);
//        ArrayList<Thread> arrayList = new ArrayList();
//
//        for (int i = 0; i < 10; i++) {
//           arrayList.add(new Thread(cave,"person"+i)) ;
//        }
//
//        arrayList.get(0).start();
//        for (int i = 0; i < 9; i++) {
//            arrayList.get(i).join();
//            arrayList.get(i+1).start();
//        }


        for (int i = 0; i < 10; i++) {
            Cavern cavern = new Cavern(obj);
            cavern.start();
            cavern.join();

        }
    }
}
