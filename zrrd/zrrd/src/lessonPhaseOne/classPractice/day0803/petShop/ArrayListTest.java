package lessonPhaseOne.classPractice.day0803.petShop;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList animalType01 = new ArrayList();
        animalType01.add(new Dog("sai01","waite"));
        animalType01.add(new Dog("sai02","waite"));
        animalType01.add(new Dog("sai03","waite"));
        animalType01.add(new Dog("sai04","waite"));
        animalType01.add(new Dog("sai05","waite"));
        animalType01.add(new Dog("sai06","waite"));
        animalType01.add(new Dog("sai07","waite"));
        animalType01.add(new Dog("sai08","waite"));
        animalType01.add(new Dog("sai09","waite"));
        animalType01.add(new Dog("sai10","waite"));

        animalType01.add(new Cat("kag01","pink"));
        animalType01.add(new Cat("kag02","pink"));
        animalType01.add(new Cat("kag03","pink"));
        animalType01.add(new Cat("kag04","pink"));
        animalType01.add(new Cat("kag05","pink"));

        animalType01.add(new Pig("jio11","black"));
        animalType01.add(new Pig("jio22","black"));
        animalType01.add(new Pig("jio33","black"));

    }


}
