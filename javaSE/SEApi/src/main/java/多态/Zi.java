package 多态;

class Zi extends Fu {
    int num = 20;

    Zi() {
        System.out.println("initialize Zi...");
    }

    @Override
    public void m1() {
        System.out.println("Zi m1 called");
    }
}
