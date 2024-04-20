package lessonPhaseOne.classPractice.day0720.one;

import java.util.Scanner;

public class ThreadTest1{
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入打印次数：");
        int n = scanner.nextInt();
        for (int i = 0;i < n;i++){
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.print(Thread.currentThread().getName() + "A");
                }
            });

            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.print("B");
                }
            });

            Thread t3 = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.print("C");
                }
            });
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();


        }

        }


    }

