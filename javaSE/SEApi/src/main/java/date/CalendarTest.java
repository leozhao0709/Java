package date;

import java.util.Calendar;

class CalendarTest {

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(2018, Calendar.DECEMBER, 3);
        System.out.println(cal.get(Calendar.DAY_OF_WEEK));
    }
}
