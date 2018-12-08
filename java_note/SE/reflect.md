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

## 2. create object

```java
Class<?> dateClass = Class.forName("java.util.Date");
Constructor<?> dateConstructor = dateClass.getConstructor();
Object date = dateConstructor.newInstance();
if (date instanceof Date) {
    System.out.println(date);
}
```

Note:

-   Since java 9, please use `Constructor.newInstance()` to get object.

## 3. get class properties

```java
Class<?> testClass = Class.forName("bean.Person");
// Field[] fields = testClass.getFields(); // can only get public property
Field[] fields = testClass.getDeclaredFields(); // can get all properties

for (Field field: fields) {
    System.out.println(field.getName());
//            System.out.println(field.getModifiers()); // return int: 0. default 1. public 2. private 3. protected

    System.out.println(Modifier.toString(field.getModifiers()));

//            System.out.println(field.getType().getTypeName()); // get property class with package
    System.out.println(field.getType().getSimpleName()); // get property class without package
}
```

Note:

-   `testClass.getFields();` can **only get public** property. If you need all properties, please use `testClass.getDeclaredFields();`
-   `field.getModifiers()` returns a int value: 0 means default, 1 meams public, 2 means private, 3 means protected. If you don't want int value but the string value, then use `Modifier.toString(field.getModifiers())`
-   `field.getType().getTypeName()` can give the property class with package name. `field.getType().getSimpleName()` will give property class without package name.

## 4. set property value

```java
Class<?> testClass = Class.forName("bean.Person");
Field field = testClass.getDeclaredField("name");

Constructor<?> constructor = testClass.getDeclaredConstructor();
Object o = constructor.newInstance();
field.setAccessible(true); // this can access private value
field.set(o, "zhangsan");
System.out.println(field.get(o));
```

Note:

-   `field.setAccessible(true);` can make private property accessible

## 5. get method

```java
Class c = Class.forName("java.lang.Object");
//获取类中所有方法
Method[] method = c.getDeclaredMethods();
for(Method m : method){
    //方法修饰符
    System.out.println(Modifier.toString(m.getModifiers()));
    //方法的返回值类型
    Class type = m.getReturnType();
    System.out.println(type.getSimpleName());
    //方法名
    System.out.println(m.getName());
    //方法参数
    Class[] paramType = m.getParameterTypes();
    for(Class p : paramType){
        System.out.println(p.getSimpleName());
    }
}
```

Note:

-   `testClass.getMethods();` can **only get public** methods. If you need all methods, please use `testClass.getDeclaredMethods();`
-   `method.getModifiers()` returns a int value: 0 means default, 1 meams public, 2 means private, 3 means protected. If you don't want int value but the string value, then use `Modifier.toString(method.getModifiers())`
-   `method.getName()` can return the method name.
-   `method.getParameterTypes()` can return the parameter types.
-   `parameterType.getTypeName()` can give the property class with package name. `parameterType.getSimpleName()` will give property class without package name.

## 6. call a method with reflect

```java
Class<?> testClass = Class.forName("bean.Person");
//获取方法
Method method = testClass.getDeclaredMethod("m5", String.class, int.class);
//创建对象
Constructor<?> constructor = testClass.getDeclaredConstructor();
Object o = constructor.newInstance();
Object result = method.invoke(o, "admin", 10);
System.out.println(result);
```

Note:

-   Using `method.invoke()` to call the method with an object.

## 7. get consturctor

```java
Class c = Class.forName("java.lang.StringBuffer");
//获取类中所有的构造方法
Constructor[] con = c.getDeclaredConstructors();
for(Constructor co : con){
    //获取修饰符
    System.out.println(Modifier.toString(co.getModifiers()));

    //获取方法名
    System.out.println(co.getName());

    //获取方法参数
    Class[] type = co.getParameterTypes();
    for(Class t : type){
        System.out.println(t.getSimpleName());
    }
}
```

Note:

-   `testClass.getConstructors();` can **only get public** constructors. If you need all constructors, please use `testClass.getDeclaredConstructors();`
-   `constructor.getModifiers()` returns a int value: 0 means default, 1 meams public, 2 means private, 3 means protected. If you don't want int value but the string value, then use `Modifier.toString(constructor.getModifiers())`
-   `constructor.getName()` can return the constructor name.
-   `constructor.getParameterTypes()` can return the parameter types.
-   `parameterType.getTypeName()` can give the property class with package name. `parameterType.getSimpleName()` will give property class without package name.

