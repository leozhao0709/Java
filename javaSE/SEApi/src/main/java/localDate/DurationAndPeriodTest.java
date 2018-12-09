package localDate;

import java.time.*;
import java.time.temporal.ChronoUnit;

class DurationAndPeriodTest {

    public static void main(String[] args) {
        //计算两个LocalTime相差的时间
        LocalTime time1 = LocalTime.of(7, 20, 0);
        LocalTime time2 = LocalTime.of(7, 30, 10);
        Duration duration = Duration.between(time1, time2);
        System.out.println(duration.toHours()); // 0
        System.out.println(duration.toMinutes()); // 10
        System.out.println(duration.getSeconds()); // 610

        System.out.println("---------------");
        // check duration of localDateTime
        LocalDateTime ldt1 = LocalDateTime.of(2017, 7, 6, 23, 30, 0);
        LocalDateTime ldt2 = LocalDateTime.of(2017, 8, 7, 1, 30, 0);
        System.out.println(Duration.between(ldt1, ldt2).toDays()); // 31
        System.out.println(Duration.between(ldt1, ldt2).toHours()); // 746
        System.out.println(Duration.between(ldt1, ldt2).toMinutes()); // 44760


        System.out.println("---------------");
        //计算两个LocalDate相差的日期
        LocalDate date1 = LocalDate.of(1997, 7, 11);
        LocalDate date2 = LocalDate.of(2017, 5, 13);
        Period period = Period.between(date1, date2);
        System.out.println(period); //P19Y10M2D
        System.out.println(period.getYears()); // 19
        System.out.println(period.getMonths()); // 10
        System.out.println(period.getDays()); // 2

        System.out.println("--------------");
        // count between dates
        System.out.println(ChronoUnit.YEARS.between(date1, date2)); // 19
        System.out.println(ChronoUnit.MONTHS.between(date1, date2)); // 238
        System.out.println(ChronoUnit.WEEKS.between(date1, date2)); // 1035
        System.out.println(ChronoUnit.DAYS.between(date1, date2)); // 7246

    }
}
