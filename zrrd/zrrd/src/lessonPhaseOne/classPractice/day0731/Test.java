package lessonPhaseOne.classPractice.day0731;

import java.util.*;

public class Test {
    public static void main(String[] args) {
//        method1();
//        method2();
//        method3();
//        method4();
//        method5();
//        method06();
//        method07();

        ArrayList arrayList = new ArrayList(50);
        for (int i = 0; i < 50; i++) {
            arrayList.add(i);
        }

        shuffle(arrayList);
        int[] arr = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i] =(int) arrayList.get(i);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void shuffle(ArrayList<Integer> arrayList){
        for (int i = arrayList.size() - 1; i > 0; i--) {

            int replace = (int)(Math.random()*i);
            int temp = arrayList.get(i);
            arrayList.set(i,arrayList.get(replace));
            arrayList.set(replace,temp);

        }


    }
    public static void method07(){
        ArrayList list = new ArrayList(50);
        for (int i = 0; i < 50; i++) {
            list.add(i);
        }

        for (int i = 0; i < 20; i++) {

            int num = (int)(Math.random()*list.size());
            System.out.println(list.get(num));
                list.remove(num);



        }

    }

    public static void method06(){
        ArrayList arrayList = new ArrayList(20);
        while (arrayList.size() < 20){
            int num = (int)(Math.random()*50);
            if (!arrayList.contains(num)){
                arrayList.add(num);
            }
        }
        System.out.println(arrayList);
    }

    public static void method5() {
        System.out.println("随机输出的20个数：");
        int[] index = new int[20];
        for (int i = 0; i < 20; i++) {
            boolean flog = false;
            int num = (int) (Math.random() * 50);
            for (int j = 0; j < i; j++) {
                if (num == index[i]) {
                    flog = true;
                    break;
                }
            }

            if (flog){
                i--;
                continue;
            }
                index[i] = num;
                System.out.print("\t" + index[i]);

        }

    }

    public static void method4() {
        ArrayList aList = new ArrayList(50);
        for (int i = 0; i < 50; i++) {
            aList.add(i);
        }
        Collections.shuffle(aList);
        System.out.println("随机出的20个数：");
        for (int i = 0; i < 20; i++) {
            System.out.printf("\t" + aList.get(i));
        }
    }

    public static void method3() {
        Set sList = new HashSet(20);
        System.out.println("随机输出的20个数：");
        while (sList.size() < 20) {
            int num = (int) (Math.random() * 50);
            sList.add(num);
        }
        System.out.println(sList);
    }

    public static void method2() {
        ArrayList aList = new ArrayList(20);

        for (int i = 0; i < 20; i++) {
            int num = (int) (Math.random() * 50);

            if (aList.contains(num)) {
                i--;
            } else {
                aList.add(num);
            }
        }
        System.out.println("随机出来20个数：");
        System.out.println(aList);
    }

    public static void method1() {
        int[] all = new int[50];
        for (int i = 0; i < 50; i++) {
            all[i] = i;
        }

        int[] iArr = new int[50];
        for (int i = 0; i < 50; i++) {
            iArr[i] = -2;
        }
        System.out.println("method1随机出的20个数是：");
        for (int i = 0; i < 20; i++) {
            Random random = new Random();
            int j = random.nextInt(50);
            if (iArr[j] == -1) {
                iArr[j] = j;
                System.out.printf("\t" + all[j]);
            } else {
                i--;
            }
        }
    }
}
