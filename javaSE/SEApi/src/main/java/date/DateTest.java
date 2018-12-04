package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class DateTest {
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d); // Mon Dec 03 10:35:28 CST 2018
        System.out.println(d.getTime());

        Date d1 = new Date(0L);
        System.out.println(d1); // Thu Jan 01 08:00:00 CST 1970

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = format.format(d);
        System.out.println(dateStr); // 2018-12-03 10:35:28

        String s = "2018-12-03 12:00:01";
        try {
            Date d3 = format.parse(s);
            System.out.println(d3);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
