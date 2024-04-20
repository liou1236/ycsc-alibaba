package lessonPhaseOne.day0802.petShop;

public class Pig extends Animal{
//    String name = "Pig";
    public Pig(String name) {
        this.name = name;
    }

    @Override
    public void enjoy() {

    }

    @Override
    public void voice(){
        System.out.println("Pig voice:heng heng heng");
    }
}
