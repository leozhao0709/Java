# BigInteger/BigDecimal/DecimalFormat

## 1. BigInteger

```java
BigInteger b1 = new BigInteger("100");
BigInteger b2 = new BigInteger("2");

System.out.println(b1.add(b2)); // 102
System.out.println(b1.subtract(b2)); // 98
System.out.println(b1.multiply(b2)); // 200
System.out.println(b1.divide(b2)); // 50
System.out.println(Arrays.toString(b1.divideAndRemainder(b2))); // [50, 0]
```

## 2. BigDecimal

```java
System.out.println(2.0 - 1.1); // 0.8999999999999999

BigDecimal b1 = new BigDecimal(2.0);
BigDecimal b2 = new BigDecimal(1.1);
System.out.println(b1.subtract(b2)); // 0.899999999999999911182158029987476766109466552734375

BigDecimal b3 = new BigDecimal("2.0");
BigDecimal b4 = new BigDecimal("1.1");
System.out.println(b3.subtract(b4)); // 0.9

BigDecimal b5 = BigDecimal.valueOf(2.0);
BigDecimal b6 = BigDecimal.valueOf(1.1);
System.out.println(b5.subtract(b6)); // 0.9
```

Note:

-   We prefer to **use String to initial a BigDecimal**.

## 3. DecimalFormat

```java
String money = DecimalFormat.getCurrencyInstance().format(1234567);
System.out.println(money); // $1,234,567.00

DecimalFormat df1 = new DecimalFormat("###, ###");
System.out.println(df1.format(123456)); // 123,456

DecimalFormat df2 = new DecimalFormat("###, ###.##");
System.out.println(df2.format(123456.123)); // 123,456.12

DecimalFormat df3 = new DecimalFormat("###, ###.0000");
System.out.println(df3.format(123456.123)); // 123,456.1230
```
