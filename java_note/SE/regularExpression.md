# Regular Expression

## 1. normal Re

```java
String testStr = "8216-3514-qwd";
Pattern pattern = Pattern.compile("(?<first>\\d+)(?<joinOper>.)(?<Second>\\d+)");
Matcher matcher = pattern.matcher(testStr);

if (matcher.find()) {
    System.out.println(matcher.group());
    System.out.println(matcher.group("first"));
    System.out.println(matcher.group("joinOper"));
    System.out.println(matcher.group("Second"));
}
```

## 2. macther.matches

Note `matcher.matches` `pattern` will check if the whole string matches the pattern. It's like `find()` a pattern `"^pattern$"`

```java
String testStr = "8216-3514-qwd";
Pattern pattern = Pattern.compile("(?<first>\\d+)(?<joinOper>.)(?<Second>\\d+)");
Matcher matcher = pattern.matcher(testStr);

if (matcher.matches()) { // give a false as 8216-3514-qwd (whole string) doesn't match the pattern. It's not search if the string conatins the pattern, use find() instead to check if the string contains the pattern.
    System.out.println(matcher.group());
    System.out.println(matcher.group("first"));
    System.out.println(matcher.group("joinOper"));
    System.out.println(matcher.group("Second"));
}
```
