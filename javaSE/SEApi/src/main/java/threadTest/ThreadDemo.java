package threadTest;

class ThreadDemo {

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println(Thread.currentThread().getName() + "...." + i);
            }
        }).start();

        NameThread namedThread = new NameThread();
        namedThread.start();

        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "...." + i);
        }

    }
}
