package lessonPhaseOne.classPractice.day0803.petShop;

public class Lady {
    String name;
    Animal animal;
//    ArrayList arrayList;
    public Lady(){}
    public Lady(Animal animal, String name){
        this.name = name;
        this.animal = animal;
    }

    public void info(){
        System.out.println(name);
        System.out.println(animal);
    }
//    public Lady(ArrayList arrayList, String name) {
//        this.name=name;
//        this.arrayList =arrayList;
//    }

    public void myPetEnjoy(){
        System.out.print("将这只宠物卖给了"+ name + " ");
        animal.enjoy();
    }

}
