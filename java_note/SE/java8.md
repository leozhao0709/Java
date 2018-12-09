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

## 3. stream

```java
List<Student> result = stuList.stream()
                                .filter((s) -> s.getScore() >= 90)
                                .sorted((s1, s2) -> Integer.compare(s2.getScore(), s1.getScore()))
                                .collect(Collectors.toList());
System.out.println(result);

OptionalDouble average = stuList.stream()
        .mapToInt(Student::getScore)
        .average();
System.out.println(average.getAsDouble());

IntStream intStream = IntStream.range(0, 10);
System.out.println(Arrays.toString(intStream.toArray()));

long count = IntStream.range(0, 100)
                .filter((val) -> val % 2 == 0)
                .count();
System.out.println(count);
```

Note:

-   We can use `.collect(Collectors.toList())` to convert a stream to List.
-   There are also other method like `map`, `filter` and `reducer`.
-   Besides `stream`, java 8 also provide `IntStream`, `DoubleStream` and `LongStream`. These streams have some special method like `sum()` and `average()`. Note please use `mapToInt`, `mapToDouble` and `mapToLong` to conver stream to corresponding stream.
-   There are also range method in java 8. `IntStream intStream = IntStream.range(0, 10);`
-   stream also has `count()` method which will give the length of the stream.

## 4. customer stream

```java
//使用Stream.of创建流
Stream<String> str =  Stream.of("i","love","this","game");
str.map(String::toUpperCase).forEach(System.out::println);

//使用数组创建流
int[] num = {2,5,9,8,6};
IntStream intStream = Arrays.stream(num);
int sum = intStream.sum();//求和
System.out.println(sum);

//由函数生成流，创建无限流
Stream.iterate(0, n -> n+2)
        .limit(10)
        .forEach(System.out::println);
```

Note:

-   There are 3 ways to create stream. `Stream.of`, `Arrays.stream` and `Stream.iterate`.

## 5. Optional

```java
List<Student> stuList = InitData.getStudent();
Optional<Integer> count = stuList.stream()
        .filter(s -> s.getScore()<60)
        .map(Student::getScore)
        .reduce((a,b) -> a+b);
System.out.println(count.orElse(0));


Map<Integer,String> map = new HashMap<>();
map.put(1001, "篮球");
map.put(1002, "足球");
map.put(1003, "羽毛球");
map.put(1004, "乒乓球");
String sport = Optional.ofNullable(map.get(1005))
                                .orElse("无");
System.out.println(sport);
```

Note:

- With optinal, we can use `orElse` or `ofNullable` or other method.    
