package lessonPhaseOne.day0802.petShop;

public class Test {
    public static void main(String[] args) {
        Lady lady1 = new Lady(Store.getInstance("dog"),"张女士");
        System.out.println(lady1.name+lady1.animal);
        lady1.myPetEnjoy();

        Lady lady2 = new Lady(Store.getInstance("cat"),"王女士");
        System.out.println(lady2.name+lady2.animal);
        lady2.myPetEnjoy();
    }
}
