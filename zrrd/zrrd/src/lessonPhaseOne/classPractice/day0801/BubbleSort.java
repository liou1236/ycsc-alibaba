package lessonPhaseOne.classPractice.day0801;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr = {3,5,7,1,2,9};
//        for (int i = 0,j = arr.length-1;i < arr.length&&j >= 0;i++,j--){
//            if (arr[i] < arr[j]){
//                arr[i] = arr[j];
//            }
//        }
//        System.out.println(Arrays.toString(arr));
        int[] arr = {3,5,7,1,2,9};
        for (int i = 0;i < arr.length;i++){
            for (int j = arr.length-1;j >0;j--){
                if (arr[j-1] > arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
//
//        第一轮：{60,70,33,55,11,22,80}
        // {"60,70"
        // {60,"33,70"
        // {60,33,"55,70"
        // {60,33,55,"11,70"
        // {60,33,55,11,"22,70"
        // {60,33,55,11,22,"70,80"

        //第二轮：{60,33,55,11,22,70,80}
        // {"33,60"
        // {33,"55,60"
        // {33,55,"11,60"
        // {33,55,11,"22,60"
        // {33,55,11,22,"60,70"

        // 二：{33,55,11,22,60,77,80}
        // 三：{33,11,22,55,60,77,80}
        // 四：{11,22,33,55,60,77,80}
        // {
        // {
        // {
        int[] arr1 ={60,77,33,55,11,22,80};
        for (int i = 0;i < arr1.length - 1;i++){

            for (int j = 0; j < arr1.length-1-i; j++) {
                System.out.println(i+" "+j);
                if (arr1[j] > arr1[j+1]){
                    System.out.println("交换数："+arr1[j]+" "+arr1[j+1]);
                    int temp =arr1[j];
                    arr1[j] = arr1[j+1];
                    arr1[j+1] = temp;
                    System.out.println(Arrays.toString(arr1));
                }
            }
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println("+++++++++++++++++");
        int[] arr2 ={60,77,33,55,11,22,80};

        for (int i = 0;i < arr2.length - 1;i++){
            boolean isSorted = true;
            for (int j = 0; j < arr2.length-1-i; j++) {
                System.out.println(i+" "+j);
                if (arr2[j] > arr2[j+1]){
                    System.out.println("交换数："+arr2[j]+" "+arr2[j+1]);
                    int temp =arr2[j];
                    arr2[j] = arr2[j+1];
                    arr2[j+1] = temp;
                    System.out.println(Arrays.toString(arr2));
                    isSorted = false;
                }
            }
            if (isSorted )break;

        }
        System.out.println(Arrays.toString(arr2));

        System.out.println("+++++++++++++++++");
        int[] arr3 ={60,77,33,55,11,22,80};

        int changeIndex = 0;
        int lastChangeIndex = arr.length - 1;
        for (int i = 0;i < arr3.length - 1;i++){
            boolean isSorted = true;
            for (int j = 0; j < lastChangeIndex; j++) {
                System.out.println(i+" "+j);
                if (arr3[j] > arr3[j+1]){
                    System.out.println("交换数："+arr3[j]+" "+arr3[j+1]);
                    int temp =arr3[j];
                    arr3[j] = arr3[j+1];
                    arr3[j+1] = temp;
                    System.out.println(Arrays.toString(arr3));
                    isSorted = false;

                    changeIndex = j;
                }
            }
            lastChangeIndex = changeIndex;
            if (isSorted )break;

        }
        System.out.println(Arrays.toString(arr3));
    }
}
