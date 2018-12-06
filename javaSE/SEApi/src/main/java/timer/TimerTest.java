package timer;

import java.util.Timer;
import java.util.TimerTask;

class TimerTest {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("scheduled task....");
            }
        }, 0, 1000);
    }
}
