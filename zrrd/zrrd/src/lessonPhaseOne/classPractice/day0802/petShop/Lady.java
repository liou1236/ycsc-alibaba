package lessonPhaseOne.day0802.petShop;

public class Lady {
    String name;
    Animal animal;
    public Lady(Animal animal, String name){
        this.name = name;
        this.animal = animal;
    }
    public void myPetEnjoy(){
        System.out.print("创建了一位"+ name );
        animal.enjoy();
    }

}
