# SerializeAndDeserialize

## 1. make object can be Serialize and Deserialize

```java
public class Student implements Serializable {
    /**
     * 自动生成序列化版本号
     */
    private static final long serialVersionUID = -716323668524282676L;

    private String name;

    //age不序列化
    transient private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

Note:

-   Object needs implement `Serializable` which doesn't have any override method.
-   Use `serialVersionUID` if you may change the object later.
-   Use `transient` to make property not Serializable.

## 2. Serialize

```java
Student s = new Student();
s.setName("张三");

// 创建输出流(序列化流) 
try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("zhangsan"));) {
    //将对象写出到硬盘中
    oos.writeObject(s);
    oos.flush();
} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}
```

## 3. Deserialize

```java
try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("zhangsan"));) {
    Student s = (Student)ois.readObject();
    System.out.println(s.getName());
} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
} catch (ClassNotFoundException e) {
    e.printStackTrace();
}
```