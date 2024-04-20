package lessonPhaseOne.classPractice.day0803.petShop;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Lady lady1 = new Lady(Store.getInstance("dog"),"张女士");
        System.out.println(lady1.name+lady1.animal);
        lady1.myPetEnjoy();

        Lady lady2 = new Lady(Store.getInstance("cat"),"王女士");
        System.out.println(lady2.name+lady2.animal);
        lady2.myPetEnjoy();



        System.out.println("====================");
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

        Random random = new Random();
        int index = random.nextInt(animalType01.size());
        Lady lady3 =new Lady(Store.getInstance1(animalType01,index),"李女士");
        lady3.info();
        lady3.myPetEnjoy();

        System.out.println("=======================");

        String[] aName = {"jj","ii","pp","ll","yy","aa","uu"};
        String[] aColor = {"pink","white","black","blue","yellow","brown"};
        LinkedList<Animal> list = new LinkedList<>();
        String i = aName[random.nextInt(aName.length)];
        String j = aColor[random.nextInt(aColor.length)];


        list.add(new Dog(i,j));
        list.add(new Cat(i,j));
        list.add(new Pig(i,j));
        int index1 = random.nextInt(list.size());

        Lady lady4 = new Lady(Store.getInstance2(list,index1),"刘女士");
        lady4.info();
        lady4.myPetEnjoy();

    }
}
