package lessonPhaseOne.day070711;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
//        hashMap.put("01",0);
//        hashMap.put("02",0);
//        hashMap.put("03",0);
//        System.out.println(hashMap.size());

        hashMap.put("01",5);
        hashMap.put("02",7);
        hashMap.put("03",6);
        hashMap.put("04",6);
        hashMap.put("05","06");
        hashMap.put("06",6);

        int num = (int) hashMap.get("02");
        System.out.println(num);

//        Object num1 = hashMap.get("07");
//        if (num1 == null){
//            int num11 = (int) num1;
//            System.out.println(num11);
//            // 空指针异常
//        }

        String key = "06";
        System.out.println(hashMap.containsKey(key));
        System.out.println(hashMap.containsValue(key));
        System.out.println(hashMap.containsValue(6));
        hashMap.replace("05",4);
        hashMap.remove(key);
        System.out.println(hashMap);
        // 存入，查询，删除，替换数据时，操作的都是key

    }
    public static void info(HashMap hashMap){
        Set set = hashMap.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Object key = iterator.next();
            Object value = hashMap.get(key);
            System.out.println("<" + key + "," + value + ">");
        }
    }

}
