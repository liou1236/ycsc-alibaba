package lessonPhaseOne.classPractice.day0808;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class superLotto {
    public static void main(String[] args) throws IOException {
        File file = new File("daletou.txt");
        Writer writer = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        String strLotto = randomNumber();// 中奖号码
        bufferedWriter.write(strLotto);
        System.out.println("中奖号码 " + strLotto);

//        String str1 = strLotto.replace("|","");
//        System.out.println(str1);

        String[] strRandom = new String[100];
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            strRandom[i] = randomNumber();
            arrayList.add(strRandom[i]);
        }

        BufferedWriter bufferedWriter1 = new BufferedWriter(new FileWriter("randomDLT.txt"));
        BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter("num.txt"));
        for (String str : arrayList) {
            bufferedWriter1.write(str + "\n");
            if (strLotto.equals(str)) {
                System.out.println("随机号码 " + str + "中奖");
                bufferedWriter2.write(str);
            } else {
                System.out.println("随机号码 " + str + "未中奖");
            }
        }
//        BufferedReader bufferedReader = new BufferedReader(new FileReader("randomDLT.txt"));
//        BufferedWriter bufferedWriter3 = new BufferedWriter(new FileWriter("randomDLTCopy.txt"));
//        char[] arr = new char[10240];
//        int len;
//        while ((len = bufferedReader.read(arr)) != -1) {
//            bufferedWriter3.write(arr, 0, len);
//        }
//
//
//        FileReader fileReader = new FileReader(file);
//        BufferedReader bufferedReaderCopy = new BufferedReader(fileReader);
//
//        // 逐行读取文件内容并输出到控制台
//        String line;
//        while ((line = bufferedReaderCopy.readLine()) != null) {
//            System.out.println(line);
//        }
//        bufferedReaderCopy.close();

        bufferedWriter.close();
        bufferedWriter1.close();
        bufferedWriter2.close();
//        bufferedReader.close();
//        bufferedWriter3.close();
    }

    public static String randomNumber() {
        String str = "";
        int[] arr1 = new int[35];
        int[] arr2 = new int[12];
        for (int i = 0; i < arr1.length; arr1[i] = ++i) ;
        for (int j = 0; j < arr2.length; arr2[j] = ++j) ;
//        System.out.println(Arrays.toString(arr2));
        for (int a = arr1.length - 1; a >= 0; a--) {
            int ran1 = (int) (Math.random() * 35);
            arr1[a] = arr1[a] ^ arr1[ran1];
            arr1[ran1] = arr1[a] ^ arr1[ran1];
            arr1[a] = arr1[a] ^ arr1[ran1];
        }
        for (int m = 0; m < 5; m++) {
            if (arr1[m] < 10) {
                str = str + "0" + arr1[m] + " ";
            } else {
                str = str + arr1[m] + " ";
            }
//            System.out.printf("\t"+arr1[m]);

        }
//            System.out.print("   |");
        for (int b = arr2.length - 1; b >= 0; b--) {
//            System.out.print("交换前：");
//            System.out.println(Arrays.toString(arr2));
            int ran2 = (int) (Math.random() * 12);


            if (ran2 == b){
                System.out.println("索引：" + ran2);
                System.out.println("交换前：" + arr2[b] + " " + arr2[ran2]);
//                int temp = arr2[b];
//                arr2[b] = arr1[ran2];
//                arr2[ran2] = temp;
                arr2[b] = arr2[b] ^ arr2[ran2];
                System.out.println("第一次异或：" + arr2[b] + " " + arr2[ran2]);
                arr2[ran2] = arr2[b] ^ arr2[ran2];
                System.out.println("第二次异或：" + arr2[b] + " " + arr2[ran2]);
                arr2[b] = arr2[b] ^ arr2[ran2];
                System.out.println("第三次异或：" + arr2[b] + " " + arr2[ran2]);

//                arr2[b] = arr2[b] + arr2[ran2];
//                arr2[ran2] = arr2[b] - arr2[ran2];
//                arr2[b] = arr2[b] - arr2[ran2];
                System.out.println("交换后：" + arr2[b] + " " + arr2[ran2]);
                System.out.println(Arrays.toString(arr2));
                System.out.println();
            }

//            System.out.print("交换后：");
//            System.out.println(Arrays.toString(arr2));


        }
        str = str + "| ";
        for (int n = 0; n < 2; n++) {

            if (arr2[n] < 10) {
                str = str + "0" + arr2[n] + " ";
            } else {
                str = str + arr2[n] + " ";
            }
//            System.out.printf("\t" + arr2[n]);
        }
        return str;
    }
}
