# Reflect

## 1. get class

```java
// style 1
Class class1 = Class.forName("bean.Person");

// style 2
Class class2 = Person.class;

// style 3
Person p = new Person("zhangsan", 18);
Class class3 = p.getClass();

System.out.println(class1 == class2); // true
System.out.println(class1 == class3); // true
```