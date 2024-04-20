package lessonPhaseOne.day030705;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Random;

public class MathTest {
    public static void main(String[] args) {
        System.out.println(Math.max(10,24));
        System.out.println(Math.min(20,10));
        System.out.println(Math.abs(-12));
        System.out.println("=============");
        System.out.println(Math.pow(4,3));
        System.out.println(Math.sqrt(25));
        System.out.println(Math.log10(100));
        System.out.println("+++++++++++++++++++");

        double d = 14.24656;
        System.out.println(Math.floor(d));
        System.out.println(Math.ceil(d));
        System.out.println(Math.round(d));
        System.out.println(Math.round(11.999));
        System.out.println(Math.PI);
        System.out.println("================");

        System.out.println(Math.sin(Math.PI/2));
        System.out.println(Math.cos(60));
        System.out.println(Math.atan(1));
        System.out.println(Math.sqrt(3)/2);

        System.out.println(Math.toRadians(120.0));

        System.out.println(Math.random());
        // 2~98
        System.out.println((int)(Math.random()*98)+2);
        Random random = new Random();
        // -98~2
        System.out.println(random.nextInt(100)-98);

        DecimalFormat df = new DecimalFormat("0.0");
        DecimalFormat df1 = new DecimalFormat("#.#");
        double d1 = 0.0001;
        double d2 = 1.2002;
        double d3 = 1.0002;
        System.out.println(df.format(d1));
        System.out.println(df.format(d2));
        System.out.println(df.format(d3));
        System.out.println(df1.format(d1));
        System.out.println(df1.format(d2));
        System.out.println(df1.format(d3));

        BigInteger bi = new BigInteger("2");
        BigInteger bi1 = new BigInteger("3");
        BigInteger bi2 = bi.add(bi1);
        BigInteger bi3 = bi.subtract(bi1);
        BigInteger bi4 = bi.multiply(bi1);
        BigInteger bi5 = bi.divide(bi1);
        System.out.println(bi2);
        System.out.println(bi3);
        System.out.println(bi4);
        System.out.println(bi5);
        System.out.println("+++++++++++++");
        BigInteger bi6 = new BigInteger("2");
        System.out.println(bi.compareTo(bi6));
        System.out.println(bi.compareTo(bi1));
        System.out.println(bi.equals(bi6));
    }
}
