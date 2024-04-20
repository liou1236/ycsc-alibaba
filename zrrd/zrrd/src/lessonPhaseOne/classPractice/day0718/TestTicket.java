package lessonPhaseOne.classPractice.day0718;

public class TestTicket implements Runnable{
    int ticketsNum = 100;

    Object obj = new Object();

    @Override
    public void run(){
        while (true){try{
            Thread.sleep(500);
        }catch (Exception e){
            e.printStackTrace();
        }
        synchronized (obj){

           if (ticketsNum <= 0){
               System.out.println("票卖光了");
               return;
           }
            System.out.println(Thread.currentThread().getName()
                    + " 出票 " + ticketsNum);
           ticketsNum--;
        }
    }
}
    public static void main(String[] args) {
        TestTicket testTicket = new TestTicket();
        Thread t1 =new Thread(testTicket);
        Thread t2 =new Thread(testTicket);
        Thread t3 = new Thread(testTicket);

        t3.start();
        t1.start();
        t2.start();
    }
}
