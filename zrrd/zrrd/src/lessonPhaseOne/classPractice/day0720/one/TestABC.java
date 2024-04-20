package lessonPhaseOne.classPractice.day0720.one;

import java.util.Scanner;

public class TestABC {
    static Integer count = 1;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("循环打印次数：");
        int cnt = scanner.nextInt();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i < cnt;){
                    synchronized (count) {
                        if (count % 3 == 1) {
                            System.out.print("A");
                            count++;
                            i++;
                        }
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i < cnt;){
                    synchronized (count) {
                        if (count % 3 == 2) {
                            System.out.print("B");
                            count++;
                            i++;
                        }
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i < cnt;){
                    synchronized (count) {
                        if (count % 3 == 3) {
                            System.out.print("C");
                            count++;
                            i++;
                        }
                    }
                }
            }
        }).start();

    }
}
