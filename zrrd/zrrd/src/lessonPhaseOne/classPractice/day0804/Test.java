package lessonPhaseOne.classPractice.day0804;

public class Test {
    public static void main(String[] args) {
        Object obj = new Object();
        MyList list = new MyList();

        for (int i = 0; i < 10; i++) {
            new Cavern01(list, obj).start();
        }
        for (int i = 0; i < 10; i++) {
            new Cavern001(list, obj).start();

        }
    }
}
