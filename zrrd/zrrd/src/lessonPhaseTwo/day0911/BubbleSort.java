package lessonPhaseTwo.day0911;

import java.util.Arrays;

public class BubbleSort {


    public static void main(String[] args) {
        int[] arr = {4,6,2,7,4,3,8,34,21,45,88,22};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] < arr[j]){
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
