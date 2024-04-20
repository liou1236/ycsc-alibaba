package lessonPhaseOne.day110715;

public class TestThread extends Thread{
    @Override
    public void run(){
        System.out.println(getName() + " is running");
    }

    public static void main(String[] args) {
        System.out.println("这是主函数的线程");
        TestThread thread1 = new TestThread();
        TestThread thread2 = new TestThread();
        thread1.start();
        thread2.start();

    }
}
