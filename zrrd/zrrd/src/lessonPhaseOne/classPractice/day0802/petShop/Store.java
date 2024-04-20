package lessonPhaseOne.day0802.petShop;

public class Store {

    public static Animal getInstance(String animal){
        if (animal.equals("dog")){
            return new Dog("ler","Yellow");
        } else if (animal == "pig") {
            return new Pig("jam");
        }else return new Cat("kan","blue");
    }
}
