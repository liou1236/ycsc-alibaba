package lessonPhaseOne.classPractice.day0803.petShop;

public class Pig extends Animal {
    private String skinColor;

    @Override
    public String toString() {
        return "Pig{" +
                "skinColor='" + skinColor + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    //    String name = "Pig";
    public Pig(String name,String skinColor) {
        this.name = name;
        this.skinColor = skinColor;
    }

    @Override
    public void enjoy() {
        System.out.println("Pig happy action:dance");
    }

    @Override
    public void voice(){
        System.out.println("Pig voice:heng heng heng");
    }
}
