package lessonPhaseOne.classPractice.day0720.one;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        for (int i = 0;i < 5;i++){
            new Thread1().start();
            System.out.println(Thread1.currentThread().getName());
            new Thread2().start();
            System.out.println(Thread2.currentThread().getName());
            new Thread3().start();
            System.out.println(Thread3.currentThread().getName());
        }


    }

}
