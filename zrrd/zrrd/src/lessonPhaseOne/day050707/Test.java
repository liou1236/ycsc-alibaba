package lessonPhaseOne.day050707;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        System.out.println(Character.isLetter('a'));
        System.out.println(Character.isLetter('1'));
        System.out.println(Character.toUpperCase('a'));
        System.out.println();
        String fg = "Hello World";
        System.out.println(fg.toUpperCase());
        char c = 'b';
        System.out.println(Character.toUpperCase(c));
        System.out.println(fg.toLowerCase());

        char v = '中';
        if (Character.isUpperCase(v) || Character.isLowerCase(v)){
            System.out.println("这是一个字母");
        }else {
            System.out.println("这不是一个字母");
        }

        ArrayList arrayList = new ArrayList();
        arrayList.add("1111");
        arrayList.add(11);
        arrayList.add(111L);
        System.out.println(arrayList);
        for (int i = 0;i < arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }
        System.out.println("==============");

        arrayList.set(1,234);
        arrayList.remove(2);
        for (int i = 0;i < arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }
        ArrayList list = new ArrayList();
        for (int i = 0;i < 10;i++){
            list.add(i);
        }
        System.out.println(list);

        int y =3;
        Integer iu =new Integer(y);
        int u =iu.intValue();

        Integer init = 2;
        int i = init;

        byte b1 = 1;
        list.add(b1);

        short s1 = 1;
        list.add(s1);

        int m =1 ;
        list.add(i);

        long l = 1L;
        list.add(l);

        float f = 1.0f;
        list.add(f);

        double d = 1.0;
        list.add(d);

        list.add('v');
        list.add("adfadf ");
        list.add(true);
        System.out.println(list);
        Object r = list.set(3,"str");
        System.out.println("=================");
        System.out.println(r);

        System.out.println();
        System.out.println(list);
        Student student1 = new Student("吴俊豪","computer");
        System.out.println("-----------------");
        System.out.println(list);
        Object student2 = list.set(2,student1);
        System.out.println(list);
        System.out.println(list);

        list.remove(7);
        list.set(7,student2);// set修改后传回旧值
        for (int x = 0;x < list.size();x++){
            System.out.println(list.get(x));
        }
        System.out.println(list);



    }

}
class Student{
    String name;
    String major;
    public Student(String name ,String major){
        this.major = major;
        this.name = name;
    }
    @Override
    public String toString(){
        return name + ',' + major;
    }
}
