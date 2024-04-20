package lessonPhaseOne.classPractice.day0728.serial;

import java.io.*;

public class Test {
    public static void main(String[] args) throws Exception{
//        Person person = new Person("taoge",80);
//        ObjectOutputStream oos =
//                new ObjectOutputStream(new FileOutputStream("object.txt"));
//        oos.writeObject(person);

        ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream("object.txt"));
        Person tao = (Person) ois.readObject();
        System.out.println(tao);
    }
}
