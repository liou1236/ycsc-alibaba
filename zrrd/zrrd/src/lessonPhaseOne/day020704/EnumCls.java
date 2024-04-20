package lessonPhaseOne.day020704;

public final class EnumCls {
    private int num;
    EnumCls(int num){this.num = num;}
    public static final EnumCls SUM = new EnumCls(0);
    public static final EnumCls MON = new EnumCls(1);
    public static final EnumCls TUE = new EnumCls(2);
    public static final EnumCls WED = new EnumCls(3);
    public static final EnumCls THU = new EnumCls(4);
    public static final EnumCls FRI = new EnumCls(5);
    public static final EnumCls SAT = new EnumCls(6);

    public static void main(String[] args) {
        System.out.println(EnumCls.FRI);
    }
}
