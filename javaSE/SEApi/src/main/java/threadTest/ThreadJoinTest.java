package threadTest;

class ThreadJoinTest {

    public static void main(String[] args) {
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
        t1.setDaemon(true);
        t1.start();
    }
}
