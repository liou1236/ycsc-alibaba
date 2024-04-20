package lessonPhaseOne.day120716;

public class TestThread extends Thread{
    @Override
    public void run(){
        System.out.println(getName() + " is running" );
    }

    public static void main(String[] args) {
        System.out.println("这是主函数的线程");
        System.out.println(Thread.currentThread().getPriority());

        TestThread thread = new TestThread();
        System.out.println("这是TestThread的线程");
        System.out.println(thread.getPriority());
        thread.start();


    }

}
