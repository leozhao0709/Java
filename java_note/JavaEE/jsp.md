# JSP

## 1. tag

-   `<% %>` just insert java code. Do not insert method, static or public, private, protected modifer.
-   `<%! %>` method, static or public, private, protected modifer can be insert into this tag.
-   `<%= %>` 该标签中的内容可以直接在JSP中输出变量、常量等，里面的内容是不用分号结尾的，会被JSP引擎直接翻译到_jspService方法中的out.write()方法中输出

```jsp
<%! private int a = 10; %>
<%! 
    public void m1(){
        System.out.println("m1方法");
    }
 %>

<!-- call m1 method -->
<% m1(); %> 
<% int a = 1024;%>
<%= a %>
<%= "monkey1024" %>
```

## 2. JSP inner object

![jsp内置对象](./images/JSP内置对象的类型.png)

-   `pageContext`: 页面上下文，通过该对象中的setAttribute和getAttribute方法设置访问范围只在当前页面中有效的数据，不过在当前页面范围中，数据都是可以直接使用的，所以该对象不常用
-   `out`: 该类型继承了IO流中的Writer，所以out是一个输出流对象，使用方法上跟PrintWriter类似。
-   `page`: 通过源码中可以看到，将this赋值给page，所以该对象就是servlet自己，在实际应用中不常使用
-   `exception`: 该对象通常配合page指令使用
-   `application`: 该对象和下面的对象的使用方法跟servlet中的一样
-   `request`
-   `response`
-   `session`
-   `config`