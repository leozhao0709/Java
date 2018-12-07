package threadTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class ThreadCommunicationTest {

    public static void main(String[] args) {
        PrintTest printTest = new PrintTest(1);

        Thread t1 = new Thread(() -> {
            while (true) {
                printTest.print1();
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                printTest.print2();
            }
        });

        Thread t3 = new Thread(() -> {
            while (true) {
                printTest.print3();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}

class PrintTest {

    private int flag;
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();


    PrintTest(int flag) {
        this.flag = flag;
    }

    void print1() {
        lock.lock();
        if (this.flag != 1) {
            try {
                condition1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("this is print1...");
        this.flag = 2;
        condition2.signal();
        lock.unlock();
    }

    void print2() {
        lock.lock();
        if (this.flag != 2) {
            try {
                condition2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("this is print2...");
        this.flag = 3;
        condition3.signal();
        lock.unlock();
    }

    void print3() {
        lock.lock();
        if (this.flag != 3) {
            try {
                condition3.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("this is print3...");
        this.flag = 1;
        condition1.signal();
        lock.unlock();
    }
}
