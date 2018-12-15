# JSON parse in java

## 0. dependency

```xml
<!--json-->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>1.2.54</version>
</dependency>
```

## 1. usage

```java
City c1 = new City(1005, "石家庄");
City c2 = new City(1006, "唐山");
City c3 = new City(1007, "保定");

List<City> cities = new ArrayList<>();
cities.add(c1);
cities.add(c2);
cities.add(c3);

Province hebei = new Province("hebei", cities);

String json = JSON.toJSONString(hebei);
System.out.println(json);

Province province = JSON.parseObject(json, Province.class);
System.out.println(province);
```

Note:

-   Using `JSON.toJSONString(object)` to parse an object to json. Using `JSON.parseObject(json, Province.class);` to parse a json string to corresponding object.
-   When using fastjson, your object **must** have `setter and getter` and an **empty constructor**.
