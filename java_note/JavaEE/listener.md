# Listener

## 1. [Servlet Listener](http://www.monkey1024.com/javaweb/986)

在servlet中一共有8个监听器，按照监听器的作用分类如下：

-   监听web对象创建与销毁的监听器
    -   ServletContextListener
    -   HttpSessionListener
    -   ServletRequestListener
-   监听web对象属性变化的监听器
    -   ServletContextAttributeListener
    -   HttpSessionAttributeListener
    -   ServletRequestAttributeListener
-   监听session绑定javaBean操作的监听器
    -   HttpSessionBindingListener
    -   HttpSessionActivationListener