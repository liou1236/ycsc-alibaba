package lessonPhaseOne.classPractice.day0807;

public class Test01 {
    public static void main(String[] args) {

        int b = 3; int y = 4;
        boolean bo = b++>3 && ++y>4;
        System.out.println(b);
        System.out.println(y);
        System.out.println(bo);
       int[] arr = {1,2,3,4};
        String str = "[";
        for (int x=0; x<arr.length ; x++){
            if(x!=arr.length-1)
                str = str + arr[x] + ",";
            else
                str = str + arr[x] + "]";
        }
        System.out.println(str);




    }

}
