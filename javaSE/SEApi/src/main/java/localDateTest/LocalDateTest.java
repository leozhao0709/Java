package localDateTest;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

class LocalDateTest {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println(today.format(formatter));

        LocalDate myBirthday = LocalDate.of(1991, 7, 9);
        Period period = Period.between(myBirthday, today);
        System.out.println("I'm " + period.getYears() + " years " + period.getMonths() + " months " + period.getDays() + " days old");

        long years = ChronoUnit.YEARS.between(myBirthday, today);
        long months = ChronoUnit.MONTHS.between(myBirthday, today);
        long weeks = ChronoUnit.WEEKS.between(myBirthday, today);
        long days = ChronoUnit.DAYS.between(myBirthday, today);

        System.out.println("\n--- Total --- ");
        System.out.println(years + " years");
        System.out.println(months + " months");
        System.out.println(weeks + " weeks");
        System.out.println(days + " days");

        System.out.println("\n--- Local Date Time ---");


        LocalDateTime dateTime = LocalDateTime.now();
        LocalDateTime testTime = LocalDateTime.of(1991, 7, 9, 10, 0);
        Duration duration = Duration.between(dateTime, testTime);
        System.out.println(duration.toDays());
    }

}
