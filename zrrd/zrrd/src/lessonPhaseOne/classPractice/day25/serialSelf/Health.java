package lessonPhaseOne.classPractice.day25.serialSelf;

import java.io.*;

public class Health implements Externalizable {

    String desc;
    String desc1;

    public Health() {
    }

    public Health(String desc) {
        this.desc = desc;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(desc);
//        out.writeObject(desc1);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        desc = (String) in.readObject();
//        desc1 = (String)in.readObject();
    }

    @Override
    public String toString() {
        return "Health{" +
                "desc='" + desc + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Health health = new Health("未知");
        // 序列化
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(new File("external")))) {
            health.writeExternal(objectOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 反序列化
        Health health1 = new Health();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(new File("external")))) {
            health1.readExternal(objectInputStream);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(health1);
    }
}
