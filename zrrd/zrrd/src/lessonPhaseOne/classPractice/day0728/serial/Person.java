package lessonPhaseOne.classPractice.day0728.serial;

import java.io.Serializable;

public class Person implements Serializable {
    String name;
    int age;
    Health health;
    public Person(String name,int age,Health health){

    }
    public Person(String name ,int age){
        this.age = age;
        this.name = name;
    }
    @Override
    public String toString(){
        return "Person{" + "name:" +
                name + " age:" + age + "}";
    }
}
