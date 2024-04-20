package lessonPhaseOne.day160724;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestCollection {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        Hashtable hashtable = new Hashtable();
        Vector vector = new Vector();
        Stack stack = new Stack();

        ArrayList arrayList = new ArrayList();
        List<Object> list = Collections.synchronizedList(arrayList);

        ConcurrentHashMap hashMap = new ConcurrentHashMap();
        CopyOnWriteArrayList list1 = new CopyOnWriteArrayList();
    }
}
