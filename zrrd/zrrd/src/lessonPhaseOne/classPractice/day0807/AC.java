package lessonPhaseOne.classPractice.day0807;


public class AC extends BD {
    int k = 20;
    public static void main(String args[]) {
        int i;
        BD c1 = new AC();
        i = c1.k;
        System.out.println("i=" + i);
    }
}
class BD {
    int k = 10;
}


