# Date

## 1. milliSecond and nanoSecond

-   `System.currentTimeMillis()` return the milliSecond since 01/01/1970
-   `System.nanoTime()` returns a nanoSecond that can be used to calculate time elapsed. **It's not related to 01/01/1970.**

## 2. SimpleDateFormat

|Pattern	|Example|
|:-----------:|:--------:|
|dd-MM-yy	|31-01-12|
|dd-MM-yyyy	|31-01-2012|
|MM-dd-yyyy	|01-31-2012|
|yyyy-MM-dd	|2012-01-31|
|yyyy-MM-dd HH:mm:ss	|2012-01-31 23:59:59|
|yyyy-MM-dd HH:mm:ss.SSS	|2012-01-31 23:59:59.999|
|yyyy-MM-dd HH:mm:ss.SSSZ	|2012-01-31 23:59:59.999+0100|
|EEEEE MMMMM yyyy HH:mm:ss.SSSZ	Saturday November |2012 10:45:42.720+0100|

```java
Date d = new Date();
System.out.println(d); // Mon Dec 03 10:53:53 CST 2018
System.out.println(d.getTime()); // 1543807617669

Date d1 = new Date(0L);
System.out.println(d1); // Thu Jan 01 08:00:00 CST 1970

// conver date to String
SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String dateStr = format.format(d);
System.out.println(dateStr); // 2018-12-03 10:53:53

// convert String to Date
SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String s = "2018-12-03 12:00:01";
try {
    Date d3 = format1.parse(s);
    System.out.println(d3); // Mon Dec 03 12:00:01 CST 2018
} catch (ParseException e) {
    e.printStackTrace();
}
```

Note:

-   If we want to get a date from String, use `SimpleDateFormat` to parse. `new Date(String)` is deprecated.
-   Use `date.getTime()` can get the **milliSeconds** from date.