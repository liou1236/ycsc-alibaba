package lessonPhaseOne.classPractice.day0803.petShop;

import java.util.ArrayList;
import java.util.LinkedList;

public class Store {

    public static Animal getInstance(String animal){
        if (animal.equals("dog")){
            return new Dog("ler","Yellow");
        } else if (animal == "pig") {
            return new Pig("jam","black");
        }else return new Cat("kan","blue");
    }
public static Animal getInstance1(ArrayList<Animal> arrayList,int index){
        return arrayList.get(index);
}
public static Animal getInstance2(LinkedList<Animal> list, int index1){
        return list.get(index1);
}
}
