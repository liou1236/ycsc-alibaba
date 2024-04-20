package lessonPhaseOne.day120716;

import lessonPhaseOne.classPractice.day0714.Test;
import lessonPhaseOne.day110715.TestJoin;

public class TestJoinMIlls extends Thread{

    public TestJoinMIlls(String name){
        super(name);
    }

    @Override
    public void run(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < 50; i++) {
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new TestJoin("Thread11").start();
        for (int i = 0; i < 50; i++) {
            if (i == 20){
                TestJoinMIlls thread22 = new TestJoinMIlls("Thread22");
                thread22.start();
                thread22.join(300);
            }
            System.out.println(Thread.currentThread().getName()
            + " " + i);
        }
    }
}
