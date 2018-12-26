package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

@WebServlet(name = "UploadServlet", urlPatterns = {"/upload"})
@MultipartConfig(maxRequestSize = 1024*100)
public class UploadServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String uploadsPath = this.getServletContext().getRealPath("/uploads");
        System.out.println(uploadsPath);

        Part part = request.getPart("photo");
        String fileName = part.getSubmittedFileName();
        fileName = UUID.randomUUID() + "_" + fileName;

        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now .getDayOfMonth();

        uploadsPath += File.separator + year + File.pathSeparator + month + File.pathSeparator + day;
        File parentDir = new File(uploadsPath);

        if (!parentDir.exists()) {
            parentDir.mkdirs();
        }

        part.write(uploadsPath + "/" + fileName);
    }

}
