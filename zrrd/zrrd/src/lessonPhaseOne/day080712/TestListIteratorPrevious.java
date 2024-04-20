package lessonPhaseOne.day080712;

import java.util.ArrayList;
import java.util.ListIterator;

public class TestListIteratorPrevious {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        ListIterator listIterator = arrayList.listIterator();
        while (listIterator.hasNext()){
            System.out.println(listIterator.next());
        }
        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }

//        Collections.shuffle(arrayList);
//        Collections.swap(arrayList,0,2);
//        Collections.rotate(arrayList,3);
//        Collections.rotate(arrayList,-2);
//        Collections.frequency(arrayList,2);


    }
}
