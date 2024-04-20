package lessonPhaseOne.classPractice.day25.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {

    public static void main(String[] args) throws Exception {
        // 序列化
        Person person = new Person("taoge", 80,
                new Health("未知"));
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("objectNew.txt"));
//        oos.writeObject(person);

        // 反序列化
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("objectNew.txt"));
//        Person tao = (Person) ois.readObject();
//        System.out.println(tao);

//        System.out.println(person == tao);

        Health health = new Health("健康");
        Person person1 = new Person("lichunquan", 18, health);
        Person person2 = new Person("duhang", 20, health);
        oos.writeObject(health);
        oos.writeObject(person1);
        oos.writeObject(person2);

        // health被序列化几次呢？
        // 3次  1次
        Health result1 = (Health) ois.readObject();
        Person result2 = (Person) ois.readObject();
        Person result3 = (Person) ois.readObject();

        System.out.println(result1 == result2.health);
        System.out.println(result1 == result3.health);


    }
}
