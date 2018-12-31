# Map

## 1. HashMap

`HashMap` doesn't have any specific key order.

## 2. LinkedHashMap

`LinkedHashMap` will **keep the added entrySet order** when you get value from it.

## 3. TreeMap

`TreeMap` will sort the element according to its key.

## 4. traverse

```java
public static void main(String[] args) {
    Map<Integer, String> map = new HashMap<>();
    map.put(1001, "成龙");
    map.put(1002, "周润发");
    map.put(1003, "周星驰");
    map.put(1004, "刘德华");

    //键和值被封装成了Entry对象,并存储在Set集合中
    Set<Map.Entry<Integer,String>> entrySet = map.entrySet();
    Iterator<Map.Entry<Integer,String>> it = entrySet.iterator();
    while(it.hasNext()) {
        //获取每一个Entry对象
        Entry<Integer,String> en = it.next();    
        //根据键值对对象获取键
        Integer key = en.getKey();        
        //根据键值对对象获取值
        String value = en.getValue();    
        System.out.println("键：" + key + "，值：" + value);
    }


    //增强for循环
    for (Entry<Integer, String> en : map.entrySet()) {
        System.out.println("键：" + en.getKey() + "，值：" + en.getValue());
    }
}
```