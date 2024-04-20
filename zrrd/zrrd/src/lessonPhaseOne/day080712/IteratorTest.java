package lessonPhaseOne.day080712;

import java.util.ArrayList;
import java.util.ListIterator;

public class IteratorTest {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        ListIterator listIterator = arrayList.listIterator();
        while (listIterator.hasNext()){
            Object o1 = null;
//            String s = (String) listIterator.next();
            int i = (int)listIterator.next();
//            System.out.println(s); ClassCastException整数不能通过迭代器转换为字符串类型
//            System.out.println(i);
            if (i == 1) listIterator.remove();
//            if (i == 1) arrayList.remove(i); 迭代过程中修改导致报错
            System.out.println(i);
//            if (i == 1) o1 = i;
//            System.out.println();
//            System.out.println("o1:" + o1);
//            System.out.println();
        }
        arrayList.remove(0);
        System.out.println(arrayList);
        System.out.println("+++++++++++++++++++");

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

        for (Object obj : arrayList){
            System.out.println(obj);
        }
        System.out.println("--------------------");

        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(1);
        arrayList1.add(2);
        arrayList1.add(3);
        arrayList1.add(4);
        ListIterator<Integer> listIterator1 = arrayList1.listIterator();
        while (listIterator1.hasPrevious()){
            int pre = listIterator1.previous();
            System.out.println(pre);
        }

    }


}
