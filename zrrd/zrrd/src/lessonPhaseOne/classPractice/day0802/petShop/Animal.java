package lessonPhaseOne.day0802.petShop;

public abstract class Animal {
    String name;
    public Animal(String name){
        this.name = name;
    }
    public abstract void enjoy();
    public Animal() {
    }

    public abstract void voice();
}
