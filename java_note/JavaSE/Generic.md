# Generic

## 1. basic

-   `? extends E` 向下限定，E及其子类，可以存储当前类型的子类
-   `? super E` 向上限定，E及其父类，可以存储当前类型的父类
-   example: `List.addAll(Collection<? extends E> c);`