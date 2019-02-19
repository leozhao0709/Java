# Enum

## 1. usage

```java
enum Season {
    SPRING,
    SUMMER,
    AUTUMN,
    WINTER
}
```

## 2. customerze complex enum

```java
public enum ResultEnum {
    UNKONW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    PRIMARY_SCHOOL(100, "我猜你可能还在上小学"),
    MIDDLE_SCHOOL(101, "你可能在上初中"),

    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
```

Note:

-   Enum can also has `constructor` and `method`. But we always just give getter.
-   Each Enum value should be match with its constructor.