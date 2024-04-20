package lessonPhaseOne.classPractice.day0724;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestABC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入打印次数：");
        int count = scanner.nextInt();

        ExecutorService single = Executors.newSingleThreadExecutor();
        for (int i = 0; i < count; i++) {
           single.execute(new Runnable() {
               @Override
               public void run() {
                   System.out.print("A");
               }
           });
            single.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.print("B");
                }
            });
            single.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.print("C");
                }
            });
        }
    }
}
