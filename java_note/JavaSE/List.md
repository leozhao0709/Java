# List

## 1. ArrayList, LinkedList and Vector

-   ArrayList: 底层数据结构是数组，查询快，增删慢. 线程不安全，效率高.
-   LinkedList: 底层数据结构是链表，查询慢，增删快. 线程不安全，效率高.
-   Vector: 底层数据结构是数组，查询快，增删慢. 线程安全，效率低. Vector相对ArrayList查询慢(线程安全的). Vector相对LinkedList增删慢(数组结构). 基本不再使用.

-   If we **need thread safe** List, then use `List list = Collections.synchronizedList(new ArrayList());` to get a thread safe List.

## 2. iterator/ListIterator

Iterator/enhenced for loop problem: If you try to add/remove element during traverse, then it will give a `ConcurrentModificationException`

```java
Iterator iter = list.iterator();
while(iter.hasNext()) {
    String str = (String)iter.next(); //ConcurrentModificationException并发修改异常
    if(str.equals("monkey")) {
        list.add("1024");
    }
}
```

Please use `ListIterator` to resolve the problem

```java
// 使用ListIterator解决上面的问题
ListIterator listIter = list.listIterator();
while (listIter.hasNext()) {
    String str = (String) listIter.next();
    if (str.equals("monkey")) {
        // 使用list迭代器向集合中添加元素
        listIter.add("1024");
    }
}
System.out.println(list);
```

## 3. add/remove during traverse

Be careful: **enhanced for loop can't be used for this, it will give ConcurrentModificationException**. please Use ListIterator or normal for loop or lambda expression to do.

```java

// normal for loop
for (int i = 0; i < l.size(); i++) {
    if (l.get(i).equals("b")) {
        l.remove(i);
        i--;
    }
}

// iterator
for (ListIterator<String> iter=l.listIterator(); iter.hasNext()) {
    if (iter.next().equals("b")) {
        iter.remove();
    }
}

// lambda
l.removeIf(s -> s.equals("b"));
```