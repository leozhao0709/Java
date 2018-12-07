package threadTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class ThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService es = Executors.newFixedThreadPool(3);
        ExecutorService es = Executors.newCachedThreadPool();
        Future<String> future = es.submit(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println(Thread.currentThread().getName() + "...." + i);
            }
            return "abc";
        });

        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "...." + i);
        }

        System.out.println(future.get());
        es.shutdown();
    }
}
