package lessonPhaseOne.day141021;

import javax.swing.*;

public class TestABC1 {
    public static void main(String[] args) {
        ABCPrint print = new ABCPrint(3);
        new Thread(new RunnableA(print)).start();
        new Thread(new RunnableB(print)).start();
        new Thread(new RunnableC(print)).start();
    }
}
    class ABCPrint{
        private int num;
        public ABCPrint(int num){ this.num = num;}
        public void printA() throws InterruptedException {
            for (int i = 0; i < 5; i++) {
                synchronized(this){
                    while (num != 1){
                        this.wait();
                    }
                    System.out.print("A");
                    num = 2;
                    this.notifyAll();
                }
            }
        }
        public void printB() throws InterruptedException {
            for (int i = 0; i < 5; i++) {
                synchronized(this){
                    while (num != 2){
                        this.wait();
                    }
                    System.out.print("B");
                    num = 3;
                    this.notifyAll();
                }
            }
        }
        public void printC() throws InterruptedException {
            for (int i = 0; i < 5; i++) {
                synchronized(this){
                    while (num != 3){
                        this.wait();
                    }
                    System.out.print("C");
                    num = 1;
                    this.notifyAll();
                }
            }
        }
    }
    class RunnableA implements Runnable{
        ABCPrint print;
        public  RunnableA(ABCPrint print){
            super();
            this.print = print;
        }
        @Override
        public void run() {
            try {
                print.printA();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    class RunnableB implements Runnable{
        ABCPrint print;
        public  RunnableB(ABCPrint print){
            super();
            this.print = print;
        }
        @Override
        public void run() {
            try {
                print.printB();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    class RunnableC implements Runnable{
        ABCPrint print;
        public  RunnableC(ABCPrint print){
            super();
            this.print = print;
        }
        @Override
        public void run() {
            try {
                print.printC();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

