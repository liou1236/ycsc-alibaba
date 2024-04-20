package lessonPhaseOne.day141021;

import java.util.Scanner;
import java.util.zip.CheckedOutputStream;

public class TestABC {
    static Integer count = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入循环打印次数：");
        int cnt = scanner.nextInt();
        for (int i = 0; i < cnt; i++) {


            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < cnt; i++) {
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
                    for (int i = 0; i < cnt; i++) {
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
                    for (int i = 0; i < cnt; i++) {
                        synchronized (count) {
                            if (count % 3 == 0) {
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
}