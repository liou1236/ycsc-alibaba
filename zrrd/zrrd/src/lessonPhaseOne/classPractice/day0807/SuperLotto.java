package lessonPhaseOne.classPractice.day0807;

import java.io.*;
import java.util.HashSet;

public class SuperLotto {
    public static void main(String[] args) throws IOException {
        File file = new File("superLotto.txt");
        Writer writer = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        HashSet set = randomNumber();

            bufferedWriter.write(set.toString());


        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }

        bufferedWriter.close();
        bufferedReader.close();
        System.out.println(file);

    }
    public static HashSet randomNumber(){
        HashSet set = new HashSet();
        int[] arr1 = new int[35];
        int[] arr2 = new int[12];
        for (int i = 0; i < arr1.length;arr1[i] = ++i);
        for (int j = 0; j < arr2.length;arr2[j] = ++j);
        for (int a = arr1.length - 1; a >= 0; a--) {
            int ran1 =(int) ((Math.random()*34) + 1);
            arr1[a] = arr1[a] ^ arr1[ran1];
            arr1[ran1] = arr1[a] ^ arr1[ran1];
            arr1[a] = arr1[a] ^ arr1[ran1];
        }
        for (int m = 0; m < 5; m++) {
            set.add(arr1[m]);
//            System.out.printf("\t"+arr1[m]);

        }
//            System.out.print("   |");
        for (int b = arr2.length - 1; b >= 0; b--) {
            int ran2 =(int) ((Math.random()*11) + 1);
            arr2[b] = arr2[b] ^ arr2[ran2];
            arr2[ran2] = arr2[b] ^ arr2[ran2];
            arr2[b] = arr2[b] ^ arr2[ran2];
        }
        for (int n = 0; n < 2; n++) {
            set.add(arr2[n]);
//            System.out.printf("\t" + arr2[n]);
        }
        return set;
    }
}
