package lessonPhaseOne.classPractice.day0803.petShop;

public class Cat extends Animal {
//    String name = "Cat";
    String eyesColor = "blue";
    @Override
    public void enjoy(){
        System.out.println("Cat happy action:laugh");
    }
    public Cat(String name,String eyesColor) {
        super.name = name;
        this.eyesColor = eyesColor;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "eyesColor='" + eyesColor + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public void voice(){
        System.out.println("Cat voice:miao miao miao");
    }
}
