# Thread

## 1. Using Lambda (same with runnable interface)

```java
public static void main(String[] args) {
    // Java 1.8 lambda
    new Thread(() -> {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "...." + i);
        }
    }).start(); // use start here

    for (int i = 0; i < 50; i++) {
        System.out.println(Thread.currentThread().getName() + "...." + i);
    }
}
```

## 2. Using extends Thread

When extends `Thread`, please rewrite `run` function. But when you start the Thread, please use `NameThread.start()` (not `NameThread.run()`) to start a new thread.

```java
class NameThread extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "...." + i);
        }
    }
}
```

## 3. Thread pool

Using `Executors` and `ExecutorService` to create a thread pool. Then using `ExecutorService.submit(Runnable/Callable)` to start a new thread

Note `Runnable` can't return and can't throw exceptions. That's why `Callable` is comming.

```java
public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService es = Executors.newFixedThreadPool(3);
    Future<String> future = es.submit(() -> {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "...." + i);
        }
        return "abc";
    });

    for (int i = 0; i < 50; i++) {
        System.out.println(Thread.currentThread().getName() + "...." + i);
    }

    System.out.println(future.get()); // Future will block future thread
}
```

## 4. synchronized

Using `synchronized(anyObject(lock))` to add a synchronized code block.

**Please make sure that same resource should has the same lock.**

```java
public void sellTickets() {
    new Thread(() -> {
        synchronized (this) {
            while (this.tickets > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ": sell ticket " + this.tickets--);
            }
            System.out.println(Thread.currentThread().getName() + ": sold out!!!");
        }
    }).start();
}
```

We can also using synchronized method to run a synchronized code block

```java
public void sellTickets() {
    new Thread(this::run).start();
}

private synchronized void run() {
    while (this.tickets > 0) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ": sell ticket " + this.tickets--);
    }
    System.out.println(Thread.currentThread().getName() + ": sold out!!!");
}
```

## 5. 线程间通信

Using `wait`, `notify` and `notifyAll` to do the communication between different thread.
