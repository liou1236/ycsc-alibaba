package lessonPhaseOne.day020704;

public class OuterCls {
    private String prop = "outer";
    class InnerCls{
        private String prop = "inner";
        private void info(){
            String prop = "local";
            System.out.println(prop);// local
            System.out.println(this.prop);// inner
            System.out.println(OuterCls.this.prop);// outer

            class LocalCls{}
        }
        public void info1(){class LocalCls{}}

    }
    public void infoOuter(){new InnerCls().info();}
    public static void main(String[] args){
        new OuterCls().infoOuter();
    }
}
