package lessonPhaseOne.day070711;

import java.util.*;

public class HashSetTest {
    public static void main(String[] args) throws Exception {
        HashSet set = new HashSet();
//        set.add("2");
//        set.add("1");
//        System.out.println(set.add("1"));
//        System.out.println(set.isEmpty());
//        System.out.println(set.size());

//        for (Object obj : set){
//            System.out.println(obj);
//        }
//        Iterator iterator = set.iterator();
//
//        while (iterator.hasNext()){
//            String i1 = (String)iterator.next();
//            System.out.println(i1);
//        }
//        System.out.println("============");
//        set.add(new A());
//        set.add(new A());
//        set.add(new B());
//        set.add(new B());
//        set.add(new C());
//        set.add(new C());
//        for (Object obj : set){
//            System.out.println(obj);
//        }
//        System.out.println("------------------");
//        B b1 = new B();
//        B b2 = new B();
//        C c1 = new C();
//        C c5 = new C();
//        C c3 = new C();
//        C c4 = new C();
//        C c2 = new C();
//        System.out.println(c3 =c2);
//
//        System.out.println(b1 == b2);
//        System.out.println(b1.equals(b2));
//        System.out.println(b1);

        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add("1");
        linkedHashSet.add("2");
        linkedHashSet.add("4");
        linkedHashSet.add("3");
        linkedHashSet.add("1");
        for (Object obj : linkedHashSet) {
            System.out.println(obj);
        }
        System.out.println(Integer.compare(20, 10));// 前者比后者大，返回-1
        System.out.println(Integer.compare(10, 10));
        System.out.println(Integer.compare(10, 20));

        System.out.println("_+_+_+_+_+_+");
        D i = new D(15);
        D j = new D(17);
        System.out.println(i.compareTo(j));

        C c1 = new C();
        C c2 = new C();
        C c3 = new C();

        System.out.println(c1 == c2);

        ArrayList arrayList = new ArrayList();
        arrayList.add(new D(17));
        arrayList.add(new D(15));
        arrayList.add(new D(20));
        arrayList.add(new D(19));
        arrayList.add(new D(18));
        Collections.sort(arrayList);
        System.out.println(arrayList);

        D test1 = new D(15);
        D test2 = new D(50);
        D test3 = new D(25);
        D test4 = new D(18);

        ArrayList arrayList1 = new ArrayList();
        arrayList1.add(test1);
        arrayList1.add(test2);
        arrayList1.add(test3);
        arrayList1.add(test4);
        arrayList1.add(new D(23));
        Collections.sort(arrayList1);
        System.out.println(arrayList1);
    }


}

class D implements Comparable {
    int age;

    public D(int age) {
        this.age = age;
    }

    @Override
    public  int compareTo(Object o) {
        D d = (D) o;
        if (this.age > d.age) {
            return 1;
        } else if (this.age < d.age) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "D{" + "age=" + age + " }";
    }
}

class A {
    @Override
    public boolean equals(Object obj) {
        return true;
    }
}

class B {
    @Override
    public int hashCode() {
        return 1;
    }
}

class C {
    @Override
    public int hashCode() {
        return 2;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
