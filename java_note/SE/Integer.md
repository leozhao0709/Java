# Integer

## trick

```java
Integer i3 = 128;
Integer i4 = 128;
System.out.println(i3==i4);//false

Integer i5 = 127; 
Integer i6 = 127;
System.out.println(i5==i6); //true
```

Note:

-   比较Integer的值是否相等时，**一定要使用equals方法**
-   如果数据是在(-128~127)之间，java中在方法区中引入了一个**整型常量池**
-   **整型常量池**不会在堆中创建对象，会直接从整型常量池中拿.