package generic;

import bean.Person;
import bean.Student;

import java.util.ArrayList;
import java.util.List;

class GenericTest {

    public static void main(String[] args) {
        List<Person> l = new ArrayList<>();

        l.add(new Person("张三", 18));
        l.add(new Person("王五", 19));
        l.add(new Student("李四", 20));
        System.out.println(l);

        l.forEach((p) -> {
            if (p.equals(new Person("王五", 19))) {
                p.setAge(22);
            }
        });
        System.out.println(l);
    }
}
