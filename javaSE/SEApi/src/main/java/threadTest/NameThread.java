package threadTest;

class NameThread extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "...." + i);
        }
    }
}
