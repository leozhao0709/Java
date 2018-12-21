# Forward And Redirect

## 1. Forward

转发是指浏览器发送请求到servlet1之后，servlet1需要访问servlet2，因此在服务器内部跳转到的servlet2，转发有时也称为服务器内跳转。整个过程浏览器只发出一次请求，服务器只发出一次响应。所以，无论是servlet1还是servlet2，整个过程中，只存在一次请求，即用户所提交的请求。因此servlet1和servlet2均可从这个请求中获取到用户提交请求时所携带的相关数据。

举例：你在专卖店选中一双篮球鞋，店员告诉你这双鞋现在没有了，让你稍等下，他去另外一个专卖店去取，店员取到鞋之后把鞋放到你手中

```java
// servlet1
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");

    request.setAttribute("someNewAttr", "a new Attribute");

    request.getRequestDispatcher("forwardServletUrl").forward(request, response);
}

// servlet2
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String userName = request.getParameter("username");
    String password = request.getParameter("password");

    String someNewAttr = (String) request.getAttribute("someNewAttr");

    System.out.println("ForwardServlet2: " + userName + "....." + password + "....." + someNewAttr);
}
```

Note:

-   Use `request.getRequestDispatcher("forwardServletUrl").forward(request, response);` to forward request
-   You can add new attributes using `request.setAttribute("someNewAttr", "a new Attribute");`
-   You can get the added attribute by using `String someNewAttr = (String) request.getAttribute("someNewAttr");`



## 2. redirect

重定向是浏览器发送请求到servlet1之后，servlet1需要访问servlet2，但并未在服务器内直接访问，而是由服务器自动向浏览器发送一个响应，浏览器再自动提交一个新的请求，这个请求就是对servlet2 的请求。

对于servlet2的访问，是先由服务器响应客户端浏览器，再由客户端浏览器向服务器发送对servlet2的请求，所以重定向有时又称为服务器外跳转。

整个过程中，浏览器共提交了两次请求，服务器共发送了两次响应。只不过，第一次响应与第二次请求，对于用户来说是透明的，是感知不到的。用户认为，自己只提交了一次请求，且只收到了一次响应。

这样的话，就会有一个问题：servlet2中是无法获取到用户手动提交请求中的数据的，它只能获取到第二次请求中所携带的数据。

举例：你在专卖店选中一双篮球鞋，店员告诉你这双鞋现在没有了，附近的另一个专卖店中有这双鞋，他把那个专卖店的地址告诉你，你得到地址之后，自己到达另外一个专卖店买到了这双鞋。

```java
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.sendRedirect("redirect2");
}
```

Note:

-   Use `response.sendRedirect("redirect2");` to redirect a url.


## 3. difference for redirect and foward

**When you submit a form, if user submit form serveral times, then `redirect` url will only reach once. But `forward` url will reach to several times.**

```console
forward1...
forward1...
forward1...
forward1...
ForwardServlet2: lzhao.....**********.....a new Attribute
ForwardServlet2: lzhao.....**********.....a new Attribute
ForwardServlet2: lzhao.....**********.....a new Attribute
ForwardServlet2: lzhao.....**********.....a new Attribute


redirect1....
redirect1....
redirect1....
redirect1....
redirect2...
```