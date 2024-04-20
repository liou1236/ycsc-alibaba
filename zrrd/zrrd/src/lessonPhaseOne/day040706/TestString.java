package lessonPhaseOne.day040706;

import java.util.Random;
import java.util.Scanner;

public class TestString {
    public static void main(String[] args) {
        while (true) {

            System.out.print("长度：");
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            verifyCode(n);
            String st1 = verifyCode(n).toString();
            System.out.println("=================");
            System.out.println(Thread.currentThread().getName()+ " "+st1);
        }

    }
        public static String verifyCode(int n) {
            StringBuilder st = new StringBuilder();
            Random random = new Random();
             for (int i = 0; i < n;i++) {
                int m = random.nextInt(3);
                if (m == 0) {
                    char big = (char) (random.nextInt(26) + 'A');
                    st.append(big);

                } else if (m == 1) {
                    char low = (char) (random.nextInt(26) + 'a');
                    st.append(low);

                } else {
                    char num = (char) (random.nextInt(10) + '0');
                    st.append(num);

                }
            }
            System.out.println("++++++++++++++++++++++++");
            System.out.println(Thread.currentThread().getName()+ " "+st);
            return st.toString();
        }

}
