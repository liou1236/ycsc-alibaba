package lessonPhaseOne.day010703;

import java.util.Arrays;

public class ObjectTest {
    public static void main(String[] args) {
        PersonAnother p1 = new PersonAnother("Tony");
        PersonAnother p2 = new PersonAnother("Tony");
        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));

        int[] arr = {1,2,3};
        System.out.println(arr);
        System.out.println(Arrays.toString(arr));
    }
}
