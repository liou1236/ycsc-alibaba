package lessonPhaseOne.day010703;

public class PrimeNumber {
    public static void main(String[] args) {
        System.out.println(isPrime1(99));
    }
    public static boolean isPrime(int num){
        if (num <= 1){
            return false;
        }
        for (int i = 2;i < num/2;i++){
            int tmp = num % i;
            if (tmp == 0){
                return false;
            }
        }
        return true;
    }
    public static boolean isPrime1(int num){
        if (num <= 1){
            return false;
        }
        for (int i = 2;i < Math.sqrt(num);i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}
