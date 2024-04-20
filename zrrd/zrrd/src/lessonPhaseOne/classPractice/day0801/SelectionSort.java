package lessonPhaseOne.classPractice.day0801;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr2 ={60,77,33,80,55,11,22};
        int len = arr2.length;
        int num = 1;
        for (int i = arr2.length-1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr2[i] < arr2[j]){
                    int temp = arr2[len -1];
                    arr2[len-1] = arr2[j];
                    arr2[j] = temp;
                }
            }
            System.out.println("第"+ num +"个最大值："+arr2[len-1]);
            len--;num++;
        }
        System.out.println(Arrays.toString(arr2));
    }

}
