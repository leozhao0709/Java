package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class StreamTest {

    public static void main(String[] args) {
        List<Student> stuList = new ArrayList<>(10);

        stuList.add(new Student("刘一", 85));
        stuList.add(new Student("陈二", 90));
        stuList.add(new Student("张三", 98));
        stuList.add(new Student("李四", 88));
        stuList.add(new Student("王五", 83));
        stuList.add(new Student("赵六", 95));
        stuList.add(new Student("孙七", 87));
        stuList.add(new Student("周八", 84));
        stuList.add(new Student("吴九", 100));
        stuList.add(new Student("郑十", 95));

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
    }
}
