# Calendar

## 1. usage

```java
Calendar cal = Calendar.getInstance();
cal.set(2018, Calendar.DECEMBER, 3);
System.out.println(cal.get(Calendar.DAY_OF_WEEK));
```

Note:

-   Use `Calendar.getInstance()` to create a Calendar instance.
-   Use `cal.set` to set a date. If you doesn't set, then calendar is today.
-   Use `cal.get(Calendar.property)` to get the info you need. Like DAY_OF_WEEK, DAY_OF_WEEK_IN_MONTH, DAY_OF_MONTH etc. But note when you use `DAY_OF_WEEK`, then 1 means Sunday, 2 means Monday...