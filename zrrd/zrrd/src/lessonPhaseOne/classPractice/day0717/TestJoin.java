package lessonPhaseOne.classPractice.day0717;

public class TestJoin extends Thread{

    public TestJoin(String name){
        super(name);
    }
    @Override
    public void run(){
        for (int i = 0;i < 50;i++){
            System.out.println(getName()+ " " +i);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        new TestJoin("Thread11").start();
        for (int i = 0;i < 50;i++){
            System.out.println(Thread.currentThread().getName()+ " " +i);
            if (i == 20){

                TestJoin thread22 = new TestJoin("Thread22");
                thread22.start();
                // main的主线程中调用了 thread22线程的join()方法
                thread22.join();
            }
        }

    }
}
