# XML in java

## 0. dependency

```xml
<!--xml-->
<dependency>
    <groupId>org.dom4j</groupId>
    <artifactId>dom4j</artifactId>
    <version>2.1.1</version>
</dependency>
```

## 1. usage

```java
SAXReader reader = new SAXReader();
URL url = XMLTest.class.getClassLoader().getResource("xmlTest/book.xml");
Document document = reader.read(url);

Element root = document.getRootElement();
List<Element> elements = root.elements();

Element thirdElement = elements.get(0);
String name = thirdElement.element("name").getText();
String price = thirdElement.element("price").getText();
System.out.println(name + ": " + price);
```