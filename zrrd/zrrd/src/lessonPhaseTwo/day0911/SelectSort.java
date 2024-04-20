package lessonPhaseTwo.day0911;

import java.util.Arrays;

public class SelectSort {


    public static void main(String[] args) {
        int[] arr = {4,6,2,7,4,3,8,34,21,45,88,22};
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1;j > i; j--) {
                if (arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
