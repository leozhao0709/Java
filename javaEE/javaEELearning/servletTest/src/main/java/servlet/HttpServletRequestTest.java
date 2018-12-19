package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "HttpServletRequestTest", urlPatterns = {"/httprequesttest"})
public class HttpServletRequestTest extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");


        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        String[] hobbies = request.getParameterValues("hobby");

        System.out.println("userName: " + userName);
        System.out.println("password: " + password);
        System.out.println("hobbies: " + Arrays.toString(hobbies));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
