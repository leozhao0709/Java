package localDate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class LocalDateTimeTest {

    public static void main(String[] args) {
        //获取当前日期和时间
        LocalDateTime dateTime1 = LocalDateTime.now();
        System.out.println(dateTime1);

        LocalDateTime dateTime2 = LocalDateTime.of(2017, 7, 11, 12, 30, 20);
        System.out.println(dateTime2);

        LocalDateTime dateTime3 = LocalDateTime.parse("2012-12-20T18:30:20");
        System.out.println(dateTime3);

        LocalDateTime newdateTime1 = dateTime2.plusHours(2);
        System.out.println(newdateTime1);

        String newDateTimeStr = newdateTime1.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH点mm分ss秒"));
        System.out.println(newDateTimeStr);
    }
}
