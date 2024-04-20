package lessonPhaseOne.classPractice.day0718;

public class TestSleep {
    public static void main(String[] args) {
        long before = System.currentTimeMillis();
//      Date date = new Date();
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        long after = System.currentTimeMillis();
        System.out.println(after);
        System.out.println(after - before);
    }
}
