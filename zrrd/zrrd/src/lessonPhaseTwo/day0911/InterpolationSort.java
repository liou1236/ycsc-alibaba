package lessonPhaseTwo.day0911;

import java.util.Arrays;

public class InterpolationSort {


    public static void main(String[] args) {
        int[] arr = {4,6,2,7,4,3,8,34,21,45,88,22};

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j - 1] > arr[j] ; j--) {
                int tmp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = tmp;
            }

        }
        System.out.println(Arrays.toString(arr));
    }

}
