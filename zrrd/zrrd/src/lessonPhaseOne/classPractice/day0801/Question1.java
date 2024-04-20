package lessonPhaseOne.classPractice.day0801;

import java.util.Arrays;

public class Question1 {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,11,13,15,17,0};
        int[] arrNew = new int[10];

//        for (int i = 0; i < 6; i++) {
//            arrNew[i] = arr[i];
//            if (arr[i] == 11){
//                arrNew[i] = 10;
//            }
//        }
//        for (int i = 5;i < arr.length - 1;i++){
//            arrNew[i+1] = arr[i];
//        }

//        System.arraycopy(arr,0,arrNew,0,5);
//        arrNew[5] = 10;
//        System.arraycopy(arr,5,arrNew,6,4);

//        for (int i = 0, j = 0;i < arr.length && j < arrNew.length;i++){
//            arrNew[j++] = arr[i];
//            if (arr[i]  == 9){
//                arrNew[j++] = 10;
//            }
//        }

        for (int i = 0,j = 0;i < arr.length - 1;i++){
            arrNew[j++] = arr[i];
            if (arr[i] == 9){
                arrNew[j++] = 10;
            }
        }
        System.out.println(Arrays.toString(arrNew));

    }


}
