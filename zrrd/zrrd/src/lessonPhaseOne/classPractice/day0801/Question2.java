package lessonPhaseOne.classPractice.day0801;

import java.util.Arrays;

public class Question2 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17};
        for (int i = 0, j = 0; i < arr.length - 1; i++) {
            if (arr[i] == 11) {
                j = 1;
            }
            if (j == 1) {
                arr[i] = arr[i + 1];
            }
        }
        arr[arr.length - 1] = 0;
        System.out.println(Arrays.toString(arr));
    }

}
