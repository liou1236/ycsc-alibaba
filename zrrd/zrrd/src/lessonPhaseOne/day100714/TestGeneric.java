package lessonPhaseOne.day100714;

import java.util.ArrayList;

public class TestGeneric {
    public static void main(String[] args) {
        ArrayList<Number> arrayList = new ArrayList<>();
        arrayList.add(12);
        arrayList.add(12.34);
        print3(arrayList);

        ArrayList<Integer> arrayListInt = new ArrayList<>();
        arrayListInt.add(34);
        print2(arrayListInt);
        print3(arrayListInt);

        arrayList.addAll(arrayListInt);
        System.out.println(arrayList);
    }
    private static void print0(ArrayList<Number> arrayList){
        System.out.println(arrayList);
    }
    private static void print1(ArrayList<Integer> arrayList){
        System.out.println(arrayList);
    }
    private static void print2(ArrayList<? extends Number> arrayList){
        System.out.println(arrayList);
    }
    public static void print3(ArrayList<? super Integer> arrayList){
        System.out.println(arrayList);
    }
}
