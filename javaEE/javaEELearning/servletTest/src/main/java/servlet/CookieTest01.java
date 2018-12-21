package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CookieTest01", urlPatterns = {"/cookietest01"})
public class CookieTest01 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie1 = new Cookie("username", "admin");
        Cookie cookie2 = new Cookie("password", "12345");

//        cookie1.setPath(request.getContextPath() + "/aaa");
//        cookie2.setPath(request.getContextPath() + "/aaa");

        cookie1.setMaxAge(60 * 60); // 1 hour
        cookie2.setMaxAge(60 * 60 * 24); // 1 day

        response.addCookie(cookie1);
        response.addCookie(cookie2);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
