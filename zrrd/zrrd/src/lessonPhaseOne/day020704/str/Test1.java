package lessonPhaseOne.day020704.str;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        String str = "12341524541657634512642908";
        System.out.println(Arrays.toString(handle1(str)));
        System.out.println(Arrays.toString(handle2(str)));
        System.out.println(Arrays.toString(test1.handle3(str)));
        System.out.println(Arrays.toString(handle4(str)));
    }

    public static int[] handle1(String str){
        int[] result = new int[10];
        char c = '0';
        for (int i = 0;i < result.length;i++){
            int count = 0;
            for (char a:str.toCharArray()){
                if (a == c){
                    count++;
                }
            }
            result[i] = count;
            c+=(char)1;// 先加再转：c = char(c + 1)
        }
        return result;
    }
    public static int[] handle2(String str){
        int[] result = new int[10];
        char c = '0';
        for (int r = 0; r < 10; r++) {
            int count = 0;
            for (int i = 0; i < str.toCharArray().length; i++) {
                if (str.charAt(i) == c) {
                    count++;
                }
            }
            result[r] = count;
            c = (char)(c + 1);
        }
        return result;
    }
    public int[] handle3(String str){
        int[] result = new int[10];

        while (true){
            int length = str.length();
            char a = str.charAt(0);
            int newLength = str.replaceAll(a + "","").length();
            int num =length - newLength;
            System.out.println("字符" + a + "出现了" + num + "次");
            int index = a - '0';
            result[index] = num;
            str = str.replaceAll(a + "","");
            if (newLength == 0){
                break;
            }
        }
        return result;
    }
    public static int[] handle4(String str){
        int[] result = new int[10];

        char[] cArr = str.toCharArray();

        Arrays.sort(cArr);
        String newStr = new String(cArr);
        for (int i = 0 ;i < 10;i++) {

            char c = (char)(i + '0');
            int first = newStr.indexOf(c);
            int last = newStr.lastIndexOf(c);

            if (first != -1){
                result[i] = last - first + 1;
            }
        }
        return result;
    }
}
