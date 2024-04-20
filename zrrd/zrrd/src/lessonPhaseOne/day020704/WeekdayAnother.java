package lessonPhaseOne.day020704;

public enum WeekdayAnother {
    SUN(0);
    private final int num;
    WeekdayAnother(int num){this.num = num;}

    public static void main(String[] args) {
        WeekdayAnother day = WeekdayAnother.SUN;
        System.out.println(day == WeekdayAnother.SUN);
        System.out.println(day.equals(WeekdayAnother.SUN));
    }

}
