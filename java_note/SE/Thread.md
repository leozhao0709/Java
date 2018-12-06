# Thread

## 0. some property

-   `currentThread.setPriority(priority)` you can set priority 1 to 10. The priority is used to make CPU give more time for the thread.
-   `Thread.sleep(milliSecond);`
-   `currentThread.setDaemon(true)` set up daemon thread. **Deamon thread is a thread which will over when other non-deamon threads are all over.** In java, gc will run in Deamon thread.
-   `currentThread.yield()` 礼让other thread
-   `otherThread.join()` can used in current thread, which means other thread can join to current thread and start to run otherThread until it's finish, then it will continue currentThread.

```java
Thread t0 = new Thread(() -> {
    for (int i = 0; i < 100; i++) {
        System.out.println(Thread.currentThread().getName() + "----" + i);
    }
});

Thread t1 = new Thread(() -> {
    for (int i = 0; i < 100; i++) {
        if (i == 50) {
            try {
                t0.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "----" + i);
    }
});

t0.start();
t1.start();
```

Above example will start do an exchange between t0 and t1. But when t1 reach to 50, t0 joined. So then t0 will continue finishing its task, after finishing, then the task left in t1 will continue to run.

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

Note: **remember to call `t.start()`!!**

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

**Note `Runnable` can't return and can't throw exceptions. That's why `Callable` is comming.**

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

Note:

-   You can define `Executors.newFixedThreadPool`, then you can create **several** `future` as it is a thread pool. one future occupied one thread.
-   Please know, the `ExecutorService` is submit a `callable<T>` interface. In the example above, we are using java8 lambda expression.
-   We can also use `future.isDone()` to get whether the future thread is done or not.
-   With using `future.get()`, we can get the thread return value. But please note, when you call `future.get()`, **it will block other thread until the future thread finish and return.**
-   You can also call `es.shutdown();` to shut down the thread pool. Make sure you want to call it. **You should always just call it when you want to exit JVM.**
-   You can also use `Executors.newCachedThreadPool()`. If you create one new task, it will create a new thread. It will create 0 to `Integer.MAX_VALUE` pool threads, so be becareful when you want to use it.

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

Note:

-   Synchronized method will make all method synchronized which sometimes you don't need. You only need use synchroized block to synchronize the slow part of your code.

## 5. deadLock

```java
Object obj1 = new Object();
Object obj2 = new Object();
Thread t0 = new Thread(() -> {
    synchronized (obj1) {
        System.out.println(Thread.currentThread().getName() + "-----obj1");

        synchronized (obj2) {
            System.out.println(Thread.currentThread().getName() + "-----obj2");
        }
    }
});

Thread t1 = new Thread(() -> {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
    synchronized (obj2) {
        System.out.println(Thread.currentThread().getName() + "-----obj2");

        synchronized (obj1) {
            System.out.println(Thread.currentThread().getName() + "-----obj1");
        }
    }
});

t0.start();
t1.start();
```

Note:

-   t0 thread get the obj1 lock, then cpu change to t1 thread and get the obj2 lock. Then both obj1 and obj2 were locked.
-   If there's a **dead lock** coming, then **we can use terminal to debug**. first, using `jps` to check all the java running program and you need to find your program process. Then `jstack -l processNumber` will tell you the dead lock info.

## 6. 线程间通信

Using `wait`, `notify` and `notifyAll` to do the communication between different thread.
