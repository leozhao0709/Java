package threadTest;

class deadLockTest {

    public static void main(String[] args) {
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
    }
}
