package lessonPhaseOne.day110715;

public class TestJoin extends Thread {
    public TestJoin(String name){
        super(name);
    }
    @Override
    public void run(){
        for (int i = 0; i < 50; i++) {
            System.out.println(getName() + " " + i);
        }
    }
    public static void main(String[] args)throws Exception{
        new TestJoin("Thread11").start();
        for (int i = 0; i < 50; i++) {
            if (i == 20){
                TestJoin thread22 = new TestJoin("Thread22");
                thread22.start();
                thread22.join();
            }
            System.out.println(Thread.currentThread().getName()
            + " " + i);
        }
    }
}
