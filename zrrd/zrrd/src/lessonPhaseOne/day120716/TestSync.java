package lessonPhaseOne.day120716;

public class TestSync implements Runnable{
    static int ticketsNum = 100;
    Object obj = new Object();
    @Override
    public void run() {
        while (true){
//            synchronized (obj){
//                if (ticketsNum <= 0){
//                    System.out.println("票卖光了");
//                    return;
//                }
//                System.out.println(Thread.currentThread().getName() +
//                        " 出票" + ticketsNum);
//                ticketsNum--;
//            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            info();
                this.info();
        }
    }

    private synchronized void info(){
        if (ticketsNum <= 0){
            System.out.println("票卖光了");
            return;
        }
        System.out.println(Thread.currentThread().getName() +
                " 出票" + ticketsNum);
        ticketsNum--;
    }

//    private static synchronized void info(){
//        if (ticketsNum <= 0){
//            System.out.println("票卖光了");
//            throw new RuntimeException();
//        }
//        System.out.println(Thread.currentThread().getName() +
//                 " 出票" + ticketsNum);
//        ticketsNum--;
//    }

    public static void main(String[] args) {
        TestSync ticket = new TestSync();
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);

        t1.start();
        t2.start();
        t3.start();
    }
}
