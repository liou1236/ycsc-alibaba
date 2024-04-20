package lessonPhaseOne.day0802;

public class Test04 {
    public static void main(String[] args) {
        SonSon sonSon = new SonSon();
        System.out.println(sonSon.num);
    }


}
class Parent{
    int num = 1;
}
class Son extends Parent{
    int num1 = 2;
    int num = 3;
}
class SonSon extends Son{
    int num2;
    public SonSon(){
        super.num = 1;
        System.out.println(num);
    }


}
