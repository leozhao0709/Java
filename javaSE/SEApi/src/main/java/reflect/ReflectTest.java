package reflect;

import bean.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Date;

class ReflectTest {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
//        getClassTest();
//        createClassTest();

//        getPropertiesTest();

        setPropertiesTest();
    }

    private static void setPropertiesTest() throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> testClass = Class.forName("bean.Person");
        Field field = testClass.getDeclaredField("name");

        Constructor<?> constructor = testClass.getDeclaredConstructor();
        Object o = constructor.newInstance();
        field.setAccessible(true); // this can access private value
        field.set(o, "zhangsan");
        System.out.println(field.get(o));
    }

    private static void getPropertiesTest() throws ClassNotFoundException {
        Class<?> testClass = Class.forName("bean.Person");
        // Field[] fields = testClass.getFields(); // can only get public property
        Field[] fields = testClass.getDeclaredFields(); // can get all properties

        for (Field field: fields) {
            System.out.println(field.getName());
//            System.out.println(field.getModifiers()); // return int: 0. default 1. public 2. private 3. protected

            System.out.println(Modifier.toString(field.getModifiers()));

//            System.out.println(field.getType().getTypeName()); // get property with package
            System.out.println(field.getType().getSimpleName()); // get property type without package
        }
    }

    private static void createClassTest() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//        Class dateClass = Class.forName("java.util.Date");
//        Object date = dateClass.getDeclaredConstructor().newInstance();
//        if (date instanceof Date) {
//            System.out.println(date);
//        }

        Class<?> dateClass = Class.forName("java.util.Date");
        Constructor<?> dateConstructor = dateClass.getDeclaredConstructor();
        Object date = dateConstructor.newInstance();
        if (date instanceof Date) {
            System.out.println(date);
        }
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
