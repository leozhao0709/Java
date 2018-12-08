# Java 8 new feature

## 1. functional interface and default method in interface

**functional interface** is the interface which **only has one abstract method**. You can use `@FunctionalInterface` to annotation the interface. Then you can use lamda expression for this interface.

Default method in interface is a method that can have some content (not an abstract method). One interface can have severl default method. **With default method in interface, then java somehow can implement the multi inherit feature.**

## 2. java 8 provided functional interface

```java
@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}

@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}

@FunctionalInterface
public interface Supplier<T> {
    T get();
}

@FunctionalInterface
public interface BinaryOperator<T> extends BiFunction<T,T,T> {
    R apply(T t1, T t2);
}
```

These are some java8 provided functional interface for us to use. Here's an example how to use it.

```java
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
```

Note:

-   `Consumer<T>` is a functional interface. 
-   When you are using a functional interface in lambda expression, then you don't need to write the method name as the passed in function will exactly that only abstract method in functional interface.