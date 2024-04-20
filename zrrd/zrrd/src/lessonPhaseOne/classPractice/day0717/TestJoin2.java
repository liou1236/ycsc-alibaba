package lessonPhaseOne.classPractice.day0717;

public class TestJoin2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
            }
        });

    Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("2");
        }
    });

    Thread t3 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("3");
        }
    });

        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();

    }
}

