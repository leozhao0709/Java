# java 8 Date

## 1. instant

```java
Instant instant = Instant.now();
long timeStamp = instant.toEpochMilli();
System.out.println(timeStamp); // 1544280048764

System.out.println(instant); // 2018-12-08T14:40:48.764927Z

LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(timeStampMillis))
```

Note:

-   `Instant` will give you the `CST` Zone.
-   Use `instant.toEpochMilli()` to convert instant to a timeStamp.
-   Use `Instant.ofEpochMilli(timeStamp)` to convert a Long timeStamp to instant.
-   Use `LocalDateTime.ofInstant(instant)` to convert a instant to LocalDateTime.

## 2. ZoneDateTime

```java
ZoneId zone = ZoneId.of("America/Los_Angeles");
ZonedDateTime zonedDateTime1 = ZonedDateTime.now();

System.out.println(zonedDateTime1); // 2018-12-08T22:45:35.827526+08:00[Asia/Shanghai]

ZonedDateTime zonedDateTime2 = ZonedDateTime.now(zone);
System.out.println(zonedDateTime2); // 2018-12-08T06:46:23.801021-08:00[America/Los_Angeles]

System.out.println(zonedDateTime1.toLocalDateTime()); // 2018-12-08T22:48:36.933928
System.out.println(zonedDateTime2.toLocalDateTime()); // 2018-12-08T06:48:36.934727

System.out.println(zonedDateTime1.toInstant()); // 2018-12-08T14:49:34.126486Z
System.out.println(zonedDateTime2.toInstant()); // 2018-12-08T14:49:34.126486Z
```

Note:

-   We can use `ZoneId` to set up different zone.
-   We can easily convert `ZonedDateTime` to `LocalDateTime`, `LocalDate`, `LocalTime` or `Instant`.
-   `toInstant()` will **not** give you the zone area instant, it will still give you the `CST` zone instant.

## 3. LocalDate

```java
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
```

Note:

-   Use `isLeapYear` to 判断闰年
-   Use `localDate1.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日"));` to format a date.
-   Use `LocalDate.parse("2016-06-15");` to parse a string to localDate. But please note, it **must** be `yyyy-MM-dd` style
-   Use `localDate.plus(1, ChronoUnit.WEEKS)` or `localDate.minus(1, ChronoUnit.WEEKS)` to add or minus date.

## 4. LocalTime

```java
//获取当前时间
LocalTime time1 = LocalTime.now();
LocalTime time2 = LocalTime.now().withNano(0);//去除毫秒
System.out.println("当前时间：" + time2);

//2小时后的时间
LocalTime newTime = time1.plusHours(2);
System.out.println("两小时后：" + newTime);

// format localTime
String newTimeStr = newTime.format(DateTimeFormatter.ofPattern("hh点mm分"));
System.out.println(newTimeStr);

//设置时间
LocalTime time3 = LocalTime.of(6, 30, 28);
LocalTime time4 = LocalTime.parse("18:20:36");
System.out.println(time4);
```

Note:

-   Use `plusHours`, `minusHours` etc to add/minus time.
-   Use `localTime.format(DateTimeFormatter.ofPattern("hh点mm分"));` to format a localTime
-   Use `LocalTime.parse("18:20:36");` to parse a string to localTime. But the parse style **must** be `hh:mm:ss`.

## 5. LocalDateTime

```java
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
```

Note:

-   Use `plusHours`, `minusHours` etc to add/minus time.
-   Use `LocalDateTime.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH点mm分ss秒"));` to format a localDateTime.
-   Use `LocalDateTime.parse("2012-12-20T18:30:20");` to parse a string to localDateTime. The parse style **must** be `yyyy-MM-ddThh:mm:ss`.

## 6. Duration and Period

```java
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
System.out.println(period); // P19Y10M2D
System.out.println(period.getYears()); // 19
System.out.println(period.getMonths()); // 10
System.out.println(period.getDays()); // 2

System.out.println("--------------");
// count between dates
System.out.println(ChronoUnit.YEARS.between(date1, date2)); // 19
System.out.println(ChronoUnit.MONTHS.between(date1, date2)); // 238
System.out.println(ChronoUnit.WEEKS.between(date1, date2)); // 1035
System.out.println(ChronoUnit.DAYS.between(date1, date2)); // 7246
```

Note:

-   `Duration` can be used in `LocalTime` or `LocalDateTime`. It can get seconds, minutes, hours and days. And they are totally independent not like `Period` which is just some part combined to a period.
-   `Period` can be used in `LocalDate`. It can return a period like _P19Y10M2D_. The `period.getYears()`, `period.getMonths()` and `period.getDays()` will only give you each of that part.
-   If you need the duration in year, months, weeks or days, then you can use `ChronoUnit.YEARS.between(date1, date2)` etc.
