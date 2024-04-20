package lessonPhaseOne.classPractice.day0718;

public class TestThread extends Thread{
    @Override
    public void run(){
        System.out.println(getName() + " is running");
    }

    public static void main(String[] args) {
        System.out.println("主函数线程");
        System.out.println(Thread.currentThread().getPriority());
    }
}
