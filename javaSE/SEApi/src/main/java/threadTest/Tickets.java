package threadTest;

class Tickets {

    private int tickets = 10;

    void sellTickets() {
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
}
