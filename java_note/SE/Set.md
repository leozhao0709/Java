# Set

## 1. algorithm

In java, Set will first call `hashCode()` to calculate the hash code, if hashCode are same, then it will call `equals(Object o)` to judge elements are same or not.

## 2. HashSet

`HashSet` doesn't have any specific order.

## 3. LinkedHashSet

`LinkedHashSet` will **keep the added elements order** when you get value from it.

## 4. TreeSet

`TreeSet` will **sort** the added elements.
