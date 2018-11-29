package 多态;

class Test {

    public static void main(String[] args) {
        Fu fu = new Zi();

        System.out.println(fu.num);
        System.out.println(((Zi) fu).num);
        fu.m1();
    }
}
