package localDate;

import java.time.Instant;

class InstantTest {

    public static void main(String[] args) {

        Instant instant = Instant.now();
        long timeStamp = instant.toEpochMilli();
        System.out.println(timeStamp);

        System.out.println(instant);
    }
}
