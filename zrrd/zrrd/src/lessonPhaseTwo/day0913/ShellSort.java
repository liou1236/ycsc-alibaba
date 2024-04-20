package lessonPhaseTwo.day0913;

import java.util.Arrays;

public class ShellSort {
    int tmp;
    public void shellSort(int[] arr){
        if (arr == null || arr.length == 0){
            return;
        }
        for (int gap = arr.length/2; gap > 0; gap/=2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j >= gap && arr[j] > arr[j-gap]; j-=gap) {
                    tmp = arr[j];
                    arr[j] = arr[j - gap];
                    arr[j - gap] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {4,6,2,7,4,3,8,34,21,45,88,22};
        ShellSort shellSort = new ShellSort();
        shellSort.shellSort(arr);
    }
}
