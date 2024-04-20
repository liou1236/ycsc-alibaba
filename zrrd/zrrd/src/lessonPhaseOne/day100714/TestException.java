package lessonPhaseOne.day100714;

import java.util.ArrayList;

public class TestException {
    public static void main(String[] args){
        int i = 1;
        char c = '1';
        String str = "abc";
//        test(i,Integer.parseInt(str));
//
//        int[] arr = new int[5];
//        int index = 5;
//        int index1 = -1;
//        arr[index1] = 0;
//        arr[index] = 0;

        str = "abc123";

        System.out.println(str.charAt(5) );

        Object i1 = "ter";
        System.out.println(i1.toString());

        ArrayList list = new ArrayList();
        list.add(str);
//        char c1 = (char)list.get(0);
        System.out.println(list.get(0));

        Object str1 = "abc";
//        char c1 = (char)str1;
        System.out.println(str1);

        int a = 1,b = 0;
        int result = a/b;
        System.out.println(result);

        
    }
    public static void test(int i,int j){

    }
}
