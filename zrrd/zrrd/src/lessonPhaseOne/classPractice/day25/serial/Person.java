package lessonPhaseOne.classPractice.day25.serial;

import java.io.Serializable;

// implements Serializable
public class Person implements Serializable {

    private static final long serialVersionUID = 7567270648407467848L;

//    private static final long serialVersionUID = 2279267535089302312L;


    String otherName;
    int age;

    String telephone;

    // 健康状态
    transient Health health;

    public Person(String name, int age) {
        this.otherName = name;
        this.age = age;
    }

    public Person(String name, int age, Health health) {
        this.otherName = name;
        this.age = age;
        this.health = health;
    }

    public Person(String name, int age, String telephone, Health health) {
        this.otherName = name;
        this.age = age;
        this.telephone = telephone;
        this.health = health;
    }

    @Override
    public String toString() {
        return "Person{" +
                "otherName='" + otherName + '\'' +
                ", age=" + age +
                ", telephone='" + telephone + '\'' +
                ", health=" + health +
                '}';
    }
}
