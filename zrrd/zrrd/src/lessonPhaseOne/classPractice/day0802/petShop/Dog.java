package lessonPhaseOne.day0802.petShop;

public class Dog extends Animal{
//    private String name = "Dog";
    private String furColor = "yellow";
    @Override
    public void enjoy(){
        System.out.println("Dog happy action:call");
    }
    public Dog(String name,String furColor) {
        this.name = name;
        this.furColor = furColor;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", furColor='" + furColor + '\'' +
                '}';
    }

    @Override
    public void voice(){
        System.out.println("Dog voice:wang wang wang");
    }
}
