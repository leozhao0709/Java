# Timer

## 1. usage

timer is used to schedule a task to run.

```java
Timer timer = new Timer();
timer.schedule(new TimerTask() {
    @Override
    public void run() {
        System.out.println("scheduled task....");
    }
}, 0, 1000);
```

Note:

-   You must create a `new TimerTask() {public void run(){}}`. There are no lambda expression for it.
-   There are some method with 2 parameters. 2 parameters method always just with a delay. If we want to schedule a task, we should use the 3 parameters method. The third parameter is the schedule period.