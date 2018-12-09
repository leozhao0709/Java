package localDate;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class LocalTimeTest {

    public static void main(String[] args) {
        //获取当前时间
        LocalTime time1 = LocalTime.now();
        LocalTime time2 = LocalTime.now().withNano(0);//去除毫秒
        System.out.println("当前时间：" + time2);

        //2小时后的时间
        LocalTime newTime = time1.plusHours(2);
        System.out.println("两小时后：" + newTime);

        // format localTime
        String newTimeStr = newTime.format(DateTimeFormatter.ofPattern("hh点mm分ss秒"));
        System.out.println(newTimeStr);

        //设置时间
        LocalTime time3 = LocalTime.of(6, 30, 28);
        LocalTime time4 = LocalTime.parse("18:20:36");
        System.out.println(time4);
    }
}
