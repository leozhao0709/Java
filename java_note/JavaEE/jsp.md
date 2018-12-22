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