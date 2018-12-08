package lambda;

import java.util.function.Consumer;

class LambdaTest {

    public static void main(String[] args) {
        TestClass<String> testClass = new TestClass<>("this is a lambda test");

        testClass.test(System.out::println);
    }
}

class TestClass<T> {
    private T val;

    TestClass(T val) {
        this.val = val;
    }

    void test(Consumer<T> consumer) {
        consumer.accept(this.val);
    }
}
