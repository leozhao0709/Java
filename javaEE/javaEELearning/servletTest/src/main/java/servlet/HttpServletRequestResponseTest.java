package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(name = "HttpServletRequestResponseTest", urlPatterns = {"/httptest"})
public class HttpServletRequestResponseTest extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        String[] hobbies = request.getParameterValues("hobby");

        System.out.println("userName: " + userName);
        System.out.println("password: " + password);
        System.out.println("hobbies: " + Arrays.toString(hobbies));

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.print("userName: " + userName + " register successfully! <br>");
        writer.print("Thanks for registering!");
        writer.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
