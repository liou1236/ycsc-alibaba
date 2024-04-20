package lessonPhaseOne.classPractice.day0724;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestCollection {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        List<Objects> list = Collections.synchronizedList(arrayList);

        ConcurrentHashMap hashMap = new ConcurrentHashMap();

        CopyOnWriteArrayList list1 = new CopyOnWriteArrayList();

    }
}
