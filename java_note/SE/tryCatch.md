# Try Catch Finially

## 1. usage

```java
public class FinallyTest03 {
public static void main(String[] args){
        int i = m1();
        System.out.println(i); 

    }

    public static int m1(){
        int i = 10;
        try{
            return i;
         //这里没有catch，所以不用在后面写return了
        }finally{
            i++;
            System.out.println("finally中的i=" + i); 
        }

    }
}
```

Note:

-   Finally will **always run even if there's a return before**. The above example will first print "finally中的i=11", then print the main function i: "10"