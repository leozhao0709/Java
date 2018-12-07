package threadTest;

class Task implements Runnable{
    private boolean flag;

    public Task(boolean flag) {
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }


    @Override
    public void run() {
        while (flag) {
            System.out.println("while loop...");
        }
        System.out.println("loop over...");
    }
}

class volatileTest {

    public static void main(String[] args) throws InterruptedException {
        Task task = new Task(true);

        Thread t0 = new Thread(task);
        t0.start();

        Thread.sleep(10);
        task.setFlag(false);
    }
}
