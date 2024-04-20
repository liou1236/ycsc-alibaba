package lessonPhaseOne.day060710;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        TStudent student = new TStudent("吴俊豪","计科",
                "5班","69岁扶墙对抗",22);
        System.out.println(student);
        ArrayList list = new ArrayList();
        ArrayList list1 = new ArrayList(40);

        ArrayList list2 = new ArrayList();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);

        ArrayList list3 = new ArrayList();
        list3.add(2);
        list3.add(3);
        list3.add(4);

        list2.equals(list3);

        list2.retainAll(list3);
        list2.toString();
        System.out.println(list2);

        list2.add(0,1);
        System.out.println(list2);

        list2.removeAll(list3);
        System.out.println(list2);

        Object[] objArr = list2.toArray();
        System.out.println(objArr);
        System.out.println(Arrays.toString(objArr));

        ArrayList list4 = new ArrayList(list2);
        System.out.println(list4);

        ArrayList list5 = new ArrayList();
        list5.addAll(list2);
        System.out.println(list5);

        System.out.println(list2.contains(1));
        System.out.println(list2.contains(4));
        list2.clear();
        System.out.println(list2.size());
    }
}
