package lessonPhaseOne.day120716;

public class TestSleep {


    public static void main(String[] args) throws InterruptedException {
        long before = System.currentTimeMillis();
        System.out.println("before");
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println("end");
        System.out.println(end - before);
    }
}
