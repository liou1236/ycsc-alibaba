package lessonPhaseOne.classPractice.day0720.one;

//public class Test {
//    private int n;
//    private Object obj = new Object();
//
//    public Test(int n){
//    this.n = n;
//}
//    public static void main(String[] args) {
//        int n = 5; // 设置打印次数
//        Test printer = new Test(n);
//
//        Thread threadA = new Thread(() -> {
//            printer.printA();
//        });
//
//        Thread threadB = new Thread(() -> {
//            printer.printB();
//        });
//
//        Thread threadC = new Thread(() -> {
//            printer.printC();
//        });
//
//        threadA.start();
//        threadB.start();
//        threadC.start();
//    }
//
//    private void printC() {
//        for (int i = 0;i < n;i++){
//            synchronized (obj){
//                System.out.println("C");
//            }
//        }
//
//    private void printB() {
//        for (int i = 0;i < n;i++){
//            synchronized (obj){
//                System.out.println("B");
//            }
//        }
//
//    private void printA() {
//        for (int i = 0;i < n;i++){
//            synchronized (obj){
//                System.out.println("A");
//            }
//        }
//
//    }
//}
