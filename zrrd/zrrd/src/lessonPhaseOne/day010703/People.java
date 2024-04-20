package lessonPhaseOne.day010703;

public class People extends Object{
    String region;
    People(){
        this.region = "地球人";
        System.out.println(this.region);
    }
    public void info(){
        System.out.println("info");
        System.out.println(this.region);
    }

    public static void main(String[] args) {
        Chinese chinese = new Chinese();
        chinese.info();
        System.out.println("=============");
        Object obj = new People();
        System.out.println(obj.getClass());
        Object obj1 = new Chinese();
        System.out.println(obj1.getClass());
    }
}
