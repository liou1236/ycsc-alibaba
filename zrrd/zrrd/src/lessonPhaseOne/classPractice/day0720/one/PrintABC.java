package lessonPhaseOne.classPractice.day0720.one;
public class PrintABC {
    private int n;
    private Object lock = new Object();
    private volatile int currentThread = 1;

    public PrintABC(int n) {
        this.n = n;
    }

    public void printA() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (currentThread != 1) {
                    lock.wait();
                }
                System.out.print(Thread.currentThread().getName() + " A");
                currentThread = 2;
                lock.notifyAll();
            }
        }
    }

    public void printB() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (currentThread != 2) {
                    lock.wait();
                }
                System.out.print("B");
                currentThread = 3;
                lock.notifyAll();
            }
        }
    }

    public void printC() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (currentThread != 3) {
                    lock.wait();
                }
                System.out.print("C");
                currentThread = 1;
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        int n = 5; // 设置打印次数
        PrintABC printer = new PrintABC(n);

        Thread threadA = new Thread(() -> {
            try {
                printer.printA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                printer.printB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                printer.printC();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
