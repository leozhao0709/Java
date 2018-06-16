# Java8 LocalDate, LocalTime, LocalDatetime, Instant

[java8 time api](http://ifeve.com/20-examples-of-date-and-time-api-from-java8/)

## 1. Current Timestamp

```java
Instant instant = Instant.now();
long timeStampMillis = instant.toEpochMilli();
// long timeStampSeconds = instant.getEpochSecond();

LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(timeStampMillis))
```

## 2. localDate/localDatetime.localtime

```java
LocalDate today = LocalDate.now();
int year = today.getYear();
int month = today.getMonthValue();
int day = today.getDayOfMonth();

LocalDate dateOfBirth = LocalDate.of(2010, 01, 14);

// example check subscription method
LocalDate dateOfBirth = LocalDate.of(2010, 01, 14);
MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
MonthDay currentMonthDay = MonthDay.from(today);
if(currentMonthDay.equals(birthday)){
	System.out.println("Many Many happy returns of the day !!");
}else{
	System.out.println("Sorry, today is not your birthday");
}

// check 闰年
if (dateOfBirth.isLeapYear())

// is before or is after
LocalDate tomorrow = LocalDate.of(2014, 1, 15);
if(tommorow.isAfter(today)){
	System.out.println("Tomorrow comes after today");
}
LocalDate yesterday = today.minus(1, DAYS);
if(yesterday.isBefore(today)){
	System.out.println("Yesterday is day before today");
}

// +/- date
LocalDate previousYear = today.minus(1, ChronoUnit.YEARS);
System.out.println("Date before 1 year : " + previousYear);
LocalDate nextYear = today.plus(1, YEARS);
System.out.println("Date after 1 year : " + nextYear);

// +/- time
LocalTime time = LocalTime.now();
LocalTime newTime = time.plusHours(2); // adding two hours
System.out.println("Time after 2 hours : " + newTime);

// check how many days between 2 days
LocalDate java8Release = LocalDate.of(2014, Month.MARCH, 14);
Period periodToNextJavaRelease = Period.between(today, java8Release); // Note: period.getYear , period.getMonth, period.getDay is the year/month/day between two days
System.out.println("Months left between today and Java 8 release : " + periodToNextJavaRelease.getMonths() );

// check duration of localDateTime
LocalDateTime ldt1 = LocalDateTime.of(2017, 07, 06, 23, 30, 00);
LocalDateTime ldt2 = LocalDateTime.of(2017, 07, 07, 1, 30, 00);
System.out.println(Duration.between(ldt1, ldt2).toHours());
System.out.println(Duration.between(ldt1, ldt2).toDays());

LocalDate today = LocalDate.now();
LocalDate myBirthday = LocalDate.of(1991, 7, 9);

// count between dates
long years = ChronoUnit.YEARS.between(myBirthday, today); // 26 years
long months = ChronoUnit.MONTHS.between(myBirthday, today); // 322 months
long weeks = ChronoUnit.WEEKS.between(myBirthday, today); // 1404 weeks
long days = ChronoUnit.DAYS.between(myBirthday, today); // 9830 days
```

## 3. formatter

```java
// string to local date
String goodFriday = "Apr 18 2014";
try {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-dd-yyyy");
	LocalDate holiday = LocalDate.parse(goodFriday, formatter);
	System.out.printf("Successfully parsed String %s, date is %s%n", goodFriday, holiday);
} catch (DateTimeParseException ex) {
	System.out.printf("%s is not parsable!%n", goodFriday);
	ex.printStackTrace();
}

// local date to string
LocalDateTime arrivalDate = LocalDateTime.now();
try {
	DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm a");
	String landing = arrivalDate.format(format);
	System.out.printf("Arriving at : %s %n", landing);
} catch (DateTimeException ex) {
	System.out.printf("%s can't be formatted!%n", arrivalDate);
	ex.printStackTrace();
}
```
