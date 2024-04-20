package lessonPhaseOne.day020704;

public class Demo {
    public static void main(String[] args) {
        Person p = new Chinese();
        p.eat();

Person p1 = new Person() {
    @Override
    public void eat() {
        System.out.println("可能用筷子，可能用刀叉");
    }
};
        p1.eat();
    }
}
abstract class Person{
    public abstract void eat();
}
class Chinese extends Person{
    @Override
    public void eat(){
        System.out.println("囫囵吞枣");
    }
}
