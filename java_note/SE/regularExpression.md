# Regular Expression

## 0. String match

```java
System.out.println("mm".matches("^m{2}$"));    

String s1 = "monkey1024study1j2a3v4a";
//将数字替换为"中"
System.out.println(s1.replaceAll("\\d", "中"));
//匹配手机号
System.out.println("15188888888".matches("0?(13|14|15|18)[0-9]{9}"));
//匹配邮箱
System.out.println("monkey@monkey1024.com".matches("\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}"));
```

## 1. normal Re

```java
String testStr = "8216-3514-qwd";
Pattern pattern = Pattern.compile("(?<first>\\d+)(?<joinOper>.)(?<Second>\\d+)");
Matcher matcher = pattern.matcher(testStr);

if/while (matcher.find()) {
    System.out.println(matcher.group());
    System.out.println(matcher.group("first"));
    System.out.println(matcher.group("joinOper"));
    System.out.println(matcher.group("Second"));
}
```

Note:

-   Using `if` if you just want to have one match.
-   Using `while` if you wants to find all match.

## 2. macther.matches

Note `matcher.matches` `pattern` will check if the whole string matches the pattern. It's like `find()` a pattern `"^pattern$"`

```java
String testStr = "8216-3514-qwd";
Pattern pattern = Pattern.compile("(?<first>\\d+)(?<joinOper>.)(?<Second>\\d+)");
Matcher matcher = pattern.matcher(testStr);

while (matcher.matches()) { // give a false as 8216-3514-qwd (whole string) doesn't match the pattern. It's not search if the string conatins the pattern, use find() instead to check if the string contains the pattern.
    System.out.println(matcher.group());
    System.out.println(matcher.group("first"));
    System.out.println(matcher.group("joinOper"));
    System.out.println(matcher.group("Second"));
}
```
