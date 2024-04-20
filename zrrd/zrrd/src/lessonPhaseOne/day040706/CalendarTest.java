package lessonPhaseOne.day040706;

import java.util.Calendar;

public class CalendarTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        int hour = calendar.get(Calendar.HOUR);
        int hour1 = calendar.get(Calendar.HOUR_OF_DAY);
        System.out.println(month);
        System.out.println(hour);
        System.out.println(hour1);
        System.out.println("========================");

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int dayOfWeekInMonth = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);

        System.out.println(dayOfWeek);
        System.out.println(dayOfMonth);
        System.out.println(dayOfWeekInMonth);
        System.out.println(dayOfYear);

    }
}
