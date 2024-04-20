package lessonPhaseOne.classPractice.day0728;

public class TestRecu {
    public static void main(String[] args) {
//        System.out.println("求第几个月的兔子数量(输出各个月兔子数量)：");
//        Scanner scanner = new Scanner(System.in);
//        int sum = scanner.nextInt();
//        for (int i =1; i <= sum; i++) {
//            System.out.print("第" + i + "个月兔子数量：");
//
//        }
        System.out.println(fib(50));
    }
    public static int fib (int n){
        if (n == 1) return 1;
        if (n == 2) return 2;
        return (fib(n-1) + fib(n-2));


    }
}
