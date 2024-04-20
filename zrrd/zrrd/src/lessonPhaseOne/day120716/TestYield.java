package lessonPhaseOne.day120716;

public class TestYield extends Thread{

    public TestYield(String name){
        super(name);
    }
    @Override
    public void run(){
        for (int i = 0; i < 50; i++) {
            System.out.println(getName() + " " + i);
            if (i == 20){
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        TestYield ty1 = new TestYield("Thread-1");
        ty1.setPriority(Thread.MAX_PRIORITY);
        ty1.start();

        TestYield ty = new TestYield("Thread-0");
        ty.setPriority(Thread.NORM_PRIORITY);
        ty.start();
        System.out.println(Thread.currentThread().getPriority());

    }
}
