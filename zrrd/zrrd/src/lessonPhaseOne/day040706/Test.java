package lessonPhaseOne.day040706;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        System.out.println(date.getYear() + 1900);
        System.out.println(date.getMonth());
        System.out.println(date.getHours());

        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        Date date1 = new Date();
        System.out.println(date1);

        if (date1.before(date)){
            System.out.println("date1在date之前");
        }
        System.out.println("date在date1之前");
    }
}
