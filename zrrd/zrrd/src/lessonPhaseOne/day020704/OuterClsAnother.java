package lessonPhaseOne.day020704;

public class OuterClsAnother {
    private String prop1 = "prop1";
    private static String prop2 = "prop2";
    public void info(){
        new InnerCls1().info();
        System.out.println("=============");
        new InnerCls2().info();
        InnerCls2.info();
    }
    class InnerCls1{
        public void info(){
            System.out.println(prop1);
            System.out.println(prop2);
        }
    }
    static class InnerCls2{
        public static void info(){
            System.out.println(prop2);
        }
    }

    public static void main(String[] args) {
        new OuterClsAnother().info();
    }
}
