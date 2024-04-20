package lessonPhaseOne.classPractice.day25.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestSerial {

    public static void main(String[] args) throws Exception {
        // 序列化
        Person person = new Person("caiyuxin", 20, "0451", new Health("良好"));
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("object"));
        oos.writeObject(person);

        // 反序列化
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("object"));
        Person result = (Person) ois.readObject();

        System.out.println(result);
    }
}
