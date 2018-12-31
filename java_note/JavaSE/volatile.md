# volatile

## 1. usage

在Java内存模型中，有main memory，每个线程也有自己的memory (例如寄存器)。为了性能，一个线程会在自己的memory中保持要访问的变量的副本。这样就会出现同一个变量在某个瞬间，在一个线程的memory中的值可能与另外一个线程memory中的值，或者main memory中的值不一致的情况.

一个变量声明为volatile，就意味着这个变量是随时会被其他线程修改的，因此不能将它cache在线程memory中.

```java
public class StoppableTask extends Thread {  
  
  private volatile boolean pleaseStop;  
  
  public void run() {  
  
    while (!pleaseStop) {  
     // do some stuff...  
    }  
 }  
  
  public void tellMeToStop() {  
  
   pleaseStop = true;  
  
  }  
}  
```

假如pleaseStop没有被声明为volatile，线程执行run的时候检查的是自己的副本，就不能及时得知其他线程已经调用tellMeToStop()修改了pleaseStop的值。 

Volatile一般情况下不能代替sychronized，因为volatile不能保证操作的原子性，即使只是i++，实际上也是由多个原子操作组成：read i; inc; write i，假如多个线程同时执行i++，volatile只能保证他们操作的i是同一块内存，但依然可能出现写入脏数据的情况。如果配合Java 5增加的atomic wrapper classes，对它们的increase之类的操作就不需要sychronized