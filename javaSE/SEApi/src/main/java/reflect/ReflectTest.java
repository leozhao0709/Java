package reflect;

import bean.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

class ReflectTest {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//        getClassTest();
        createClassTest();
    }

    private static void createClassTest() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//        Class dateClass = Class.forName("java.util.Date");
//        Object date = dateClass.getDeclaredConstructor().newInstance();
//        if (date instanceof Date) {
//            System.out.println(date);
//        }

        Class dateClass = Class.forName("java.util.Date");
        Constructor dateConstructor = dateClass.getConstructor();
    }

    private static void getClassTest() throws ClassNotFoundException {
        // style 1
        Class class1 = Class.forName("bean.Person");

        // style 2
        Class<Person> class2 = Person.class;

        // style 3
        Person p = new Person("zhangsan", 18);
        Class class3 = p.getClass();

        System.out.println(class1 == class2); // true
        System.out.println(class1 == class3); // true
    }
}
