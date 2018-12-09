package localDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

class LocalDateTest {

    public static void main(String[] args) {
        //今天的日期，不包括时间
        LocalDate date1 = LocalDate.now();
        System.out.println(date1);

        int year = date1.getYear();
        int month = date1.getMonthValue();
        int day = date1.getDayOfMonth();

        //格式化日期
        String date2 = date1.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日"));
        System.out.println(date2);

        //判断闰年
        boolean leap = date1.isLeapYear();

        //获取该月份有几天
        int len = date1.lengthOfMonth();

        //设置日期
        LocalDate date3 = LocalDate.parse("2016-06-15");
        LocalDate date4 = LocalDate.of(2016, 06, 15);

        //判断两个日期是否相等
        if(date4.equals(date3)){
            System.out.println("日期相等");
        }

        //设置一周之后的日期
        LocalDate nextWeek = date1.plus(1, ChronoUnit.WEEKS);
        System.out.println("今天：" + date1);
        System.out.println("一周后：" + nextWeek);
    }
}
