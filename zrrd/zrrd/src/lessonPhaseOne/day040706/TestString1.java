package lessonPhaseOne.day040706;

import java.util.Random;
import java.util.Scanner;

public class TestString1 {
    public static void main(String[] args) {
        TestString1 testString1 = new TestString1();
        Scanner scanner = new Scanner(System.in);
        System.out.println("长度：");
        int length = scanner.nextInt();
        testString1.verifyCode(length);
    }

    public String verifyCode(int length) {
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        int select = random.nextInt();// Integer.MAX_VALUE
        char[] code = new char[length];
        for (int i = 0; i < length; i++) {
            switch (select) {
                case 0:
                    code[length] = (char) (random.nextInt(26) + 'A');
                    stringBuffer.append(code[length]);
                    break;
                case 1:
                    code[length] = (char) (random.nextInt(26) + 'a');
                    stringBuffer.append(code[length]);
                    break;
                case 2:
                    code[length] = (char) (random.nextInt(10) + '0');
                    stringBuffer.append(code[length]);
                    break;
            }
        }
        System.out.println(stringBuffer);
        return stringBuffer.toString();
    }
}
