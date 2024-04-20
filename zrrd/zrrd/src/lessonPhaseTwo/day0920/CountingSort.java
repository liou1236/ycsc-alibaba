package lessonPhaseTwo.day0920;

public class CountingSort {
    public void countingSort(int[] nums){
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = nums[i] > max ? nums[i]:max;

        }
        int[] counts = new int[max+1];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]]++;
        }
//        for (int n: nums){
//            counts[n]++;
//        }
        int i = 0;
        for (int k = 0; k < counts.length; k++) {
            for (int j = 0; j < counts[k]; j++) {
                nums[i++] = k;
            }
        }
    }
}
