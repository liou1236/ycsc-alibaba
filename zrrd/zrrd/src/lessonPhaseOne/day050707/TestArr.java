package lessonPhaseOne.day050707;

import java.util.Arrays;

public class TestArr {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3};
        int[] arr2 = {0,1};
        System.arraycopy(arr1,1,arr2,0,2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        Object[] objArr = new Object[10];
        Object[] objArrNew = Arrays.copyOf(objArr,15);
        System.out.println(objArrNew.length);

        int[] arr = {0,1,2,3,4,5,6};
        System.arraycopy(arr,2,arr,3,3);
        System.out.println(Arrays.toString(arr));
    }
}
