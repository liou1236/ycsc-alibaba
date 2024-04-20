package lessonPhaseOne.classPractice.day25.serialSelf;

import java.io.*;

public class Person implements Serializable {

    private static final long serialVersionUID = -1893655204129494924L;

    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private void writeObject(ObjectOutputStream oos) throws Exception {
        System.out.println("custom writeObject");
//        oos.defaultWriteObject();
        // 手动序列化
        oos.writeObject(name);
    }


    private void readObject(ObjectInputStream ois) throws Exception {
        System.out.println("custom readObject");
//        ois.defaultReadObject();
        // 手动反序列化
        name = (String) ois.readObject();
    }


    public static void main(String[] args) throws Exception {
        Person person = new Person("caiyuxin", 20);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person"));
        oos.writeObject(person);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person"));
        Person result = (Person) ois.readObject();
        System.out.println(result);
        ois.close();
    }

}
