package lessonPhaseOne.day060710;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorTest {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        Object o  = null;
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            Object o1 = null;
//            String i = (String)iterator.next();
            int i1 = (int)iterator.next();
//            System.out.println(i); 转换异常，iterator返回Integer类型只可转为int
            System.out.println(i1);
//            if (i1 == 1)arrayList.remove(i1);
//            if (i1 == 1)iterator.remove();
              if (i1 == 1)o = i1;
        }
        arrayList.remove(o);
        System.out.println(o);
        System.out.println(arrayList);
        System.out.println("-----------");

        for (int i = 0;i < arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }
        for (Object obj : arrayList){
            System.out.println(obj);
        }
        info();
    }
    public static void info(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        Integer i = null;

        Iterator iterator1 = arrayList.iterator();
        while (iterator1.hasNext()){
            if ((int) iterator1.next() == 4){
                i = 4;
            }
            System.out.println(i);
        }
        arrayList.remove(i);
        System.out.println(arrayList);
    }
}
