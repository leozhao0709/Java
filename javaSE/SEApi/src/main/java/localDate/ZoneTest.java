package localDate;

import java.time.ZoneId;
import java.time.ZonedDateTime;

class ZoneTest {

    public static void main(String[] args) {
        ZoneId zone = ZoneId.of("America/Los_Angeles");
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now();

        System.out.println(zonedDateTime1); // 2018-12-08T22:45:35.827526+08:00[Asia/Shanghai]

        ZonedDateTime zonedDateTime2 = ZonedDateTime.now(zone);
        System.out.println(zonedDateTime2); // 2018-12-08T06:46:23.801021-08:00[America/Los_Angeles]

        System.out.println(zonedDateTime1.toLocalDateTime()); // 2018-12-08T22:48:36.933928
        System.out.println(zonedDateTime2.toLocalDateTime()); // 2018-12-08T06:48:36.934727

        System.out.println(zonedDateTime1.toInstant()); // 2018-12-08T14:49:34.126486Z
        System.out.println(zonedDateTime2.toInstant()); // 2018-12-08T14:49:34.126486Z
    }
}
