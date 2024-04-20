package lessonPhaseOne.classPractice.day0803;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        D test1 = new D(15);
        D test2 = new D(50);
        D test3 = new D(25);
        D test4 = new D(18);

        ArrayList<D> arrayList = new ArrayList<D>();
        arrayList.add(test1);
        arrayList.add(test2);
        arrayList.add(test3);
        arrayList.add(test4);
        arrayList.add(new D(23));
        Collections.sort(arrayList);
        System.out.println(arrayList);

        D[] array = { new D(15), new D(50), new D(25), new D(18) };
        System.out.println("-------------------");
        int lastBould = array.length - 1;
        int bould = 0;
        for (int i = 0; i < array.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j <lastBould; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    D temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSorted = false;
                    bould = j;
                }
            }
            System.out.println(Arrays.toString(array));
            lastBould = bould;
            if (isSorted) {
                break;
            }
        }

//        for (D d : array) {
//            System.out.print(d + " ");
//        }
        System.out.println(Arrays.toString(array));


        D[] array1 = { new D(15), new D(50), new D(25), new D(18) };

        ArrayList<D> list = new ArrayList<D>();
        list.add(new D(18));
        list.add(new D(50));
        list.add(new D(25));
        list.add(new D(15));

//        list.addAll(Arrays.asList(array1));
        int lastBould1 = list.size() - 1;  // int size = arrayList.size()-1;
        int bould1 = list.size();  // int exchange = arrayList.size();
        System.out.println("_____________________");
        while (bould1 >= 1) {
//            boolean isSorted = true;
           bould1 = 0;
            for (int j = 0; j < lastBould1; j++) {

                if (list.get(j).compareTo(list.get(j+1)) > 0) {
//                list.set(j,list.set(j+1,list.get(j)));
                    D o = list.get(j+1);
                    list.set(j+1,list.get(j));
                    list.set(j,o);
//                    isSorted = false;
                    System.out.printf("%d %d",j,j+1);
                    bould1 = j ;
                }
                System.out.println(list);
            }
            lastBould1 = bould1;
//            if (isSorted) {
//                break;
//            }
        }

//        for (D d : array) {
//            System.out.print(d + " ");
//        }
        System.out.println(Arrays.toString(array1));
    }

}

