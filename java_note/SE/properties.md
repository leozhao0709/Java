# Properties

## 1. write properties to properties file

```java
private static void writeToProperties() {
    Properties properties = new Properties();
    properties.setProperty("BJ", "Beijing");
    properties.setProperty("NJ", "Nanjing");
    try {
        String path = PropertyTest.class.getResource("./area.properties").getPath();
        properties.store(new FileOutputStream(path), "Area Info");
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```

Note:

-   Use `properties.store(new FileOutputStream(path), "Area Info");` to write the property to a file. The second parameter is a comment that should introduce your properties file.

## 2. get properties from peroperties file (not recommend)

```java
private static void readProperties() {
    Properties properties = new Properties();
    try {
        String path = PropertyTest.class.getResource("./area.properties").getPath();
        properties.load(new FileInputStream(path));
        System.out.println(properties.getProperty("BJ"));
        System.out.println(properties.getProperty("NJ"));
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```

## 3. get properties using resource bundle (recommend)

```java
private static void readPropertiesFromResourceBundle() {
    Locale locale = new Locale("zh_cn");

    ResourceBundle rb = ResourceBundle.getBundle("package.fileNoExtension", locale);
    System.out.println(rb.getString("BJ"));
    System.out.println(rb.getString("NJ"));
}
```

Note:

-   With read properties from resource bundle, we can do **international** for a property file. We can define different properties with different localized property file.
-   We can define several international property file: ![international](./images/internaltionalPropertyFile.png)
-   When you use `ResourceBundle.getBundle("package.fileNoExtension");`, there's no extension of the properties file, but you need contains the package name.
-   You can pass a locale when you call `ResourceBundle.getBundle`, then it will get the corresponding internal properties file.
-   Use `rb.getString(key)` to get the value.