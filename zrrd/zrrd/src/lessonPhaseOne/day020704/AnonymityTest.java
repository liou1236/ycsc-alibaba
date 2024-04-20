package lessonPhaseOne.day020704;

public class AnonymityTest {
    public static void main(String[] args) {
        new Bird().fly();
        new Fly(){
            public void fly(){
                System.out.println("Anonmity fly");
            }
        }.fly();
    }

}
interface Fly{
    void fly();
}
class Bird implements Fly {
    @Override
    public void fly(){
        System.out.println("Bird fly");
    }
}