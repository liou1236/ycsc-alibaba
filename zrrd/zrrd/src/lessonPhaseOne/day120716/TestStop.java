package lessonPhaseOne.day120716;

import java.util.function.DoubleToIntFunction;

public class TestStop extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 50; i++) {
            System.out.println(getName() + " " + i);
            if (i == 30){
                throw new RuntimeException();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("这是主函数的线程");
        TestStop thread1  = new TestStop();
        thread1.start();

    }
}
