package lessonPhaseOne.classPractice.day0720.one;

public class TestABC1 {

    public static void main(String[] args) {
        ABCPrint print = new ABCPrint(1);
        new Thread(new RunnableA(print)).start();
        new Thread(new RunnableB(print)).start();
        new Thread(new RunnableC(print)).start();

    }
}
class RunnableA implements Runnable{

    ABCPrint print;
    @Override
    public void run() {
       print.printA();
    }
    public RunnableA(ABCPrint print){
        super();
        this.print = print;
    }
}
class RunnableB implements Runnable{

    ABCPrint print;
    @Override
    public void run() {
        print.printB();
    }
    public RunnableB(ABCPrint print){
        super();
        this.print = print;
    }
}
class RunnableC implements Runnable{

    ABCPrint print;
    @Override
    public void run() {
        print.printC();
    }
    public RunnableC(ABCPrint print){
        super();
        this.print = print;
    }
}
class ABCPrint {
    private int num;
    public ABCPrint(int num){
        this.num = num;
    }
    public void printA(){
        for (int i = 0; i < 5; i++) {
        synchronized (this) {
            if (num != 1){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
                System.out.print("A");
                num = 2;
                this.notifyAll();
            }
        }
    }
    public void printB(){
        for (int i = 0; i < 5; i++) {
            synchronized (this) {
                if (num != 2){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print("B");
                num = 3;
                this.notifyAll();
            }
        }
    }

    public void printC(){
        for (int i = 0; i < 5; i++) {
            synchronized (this) {
                if (num != 3){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print("C");
                num = 1;
                this.notifyAll();
            }
        }
    }
}