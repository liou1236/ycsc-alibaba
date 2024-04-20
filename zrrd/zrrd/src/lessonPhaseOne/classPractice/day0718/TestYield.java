package lessonPhaseOne.classPractice.day0718;

public class TestYield extends Thread{
    @Override
    public void run(){
        for (int i = 0;i < 50;i++){
            System.out.println(getName() + " " + i);
            if (i == 20)Thread.yield();
        }
    }

    public static void main(String[] args) {
        TestYield ty1 = new TestYield();
        ty1.setPriority(Thread.MAX_PRIORITY);
        ty1.setPriority(7);
        TestYield ty2 = new TestYield();
        ty2.setPriority(Thread.MIN_PRIORITY);

        ty1.start();
        ty2.start();
    }
}
