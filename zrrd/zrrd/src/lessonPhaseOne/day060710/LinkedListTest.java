package lessonPhaseOne.day060710;

import java.util.Collections;
import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        // list有序可重复
        LinkedList list = new LinkedList();
        list.add("node1");
        list.add("node2");
        list.add("node3");
        list.add("node4");

        for (int i = 0;i < list.size();i++){
            System.out.println(list.get(i));
        }
        System.out.println(list);

        System.out.println("----------------");
        list.add(4,"nodeNew");
        list.add(1,"nodeNow");
        list.add("ad1");// 默认添加在最后一位
        System.out.println(list);

        list.removeFirst();
        list.removeLast();
        list.remove(1);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        //list.removeAll();  用于交集移除
        list.remove();// 无参输入默认移除索引为0
        System.out.println(list);
        list.clear();
        System.out.println(list);

        System.out.println("==============");
        list.add("node");
        list.getFirst();
        list.getLast();

        System.out.println(list.get(0));
    }
}
