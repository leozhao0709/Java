package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

@Controller
class UploadsController {

    @RequestMapping("/upload")
    public ModelAndView uploadFile(@RequestParam(name = "photo") MultipartFile file, HttpServletRequest request) throws IOException {
        ModelAndView mv = new ModelAndView();

        if (!file.isEmpty()) {
            String path = request.getServletContext().getRealPath("/uploads");
            String originalFilename = file.getOriginalFilename();

            LocalDate localDate = LocalDate.now();
            int year = localDate.getYear();
            int month = localDate.getMonthValue();
            int day = localDate.getDayOfMonth();

            String uploadDirPath = path + File.separator + year + File.separator + month + File.separator + day ;
            File uploadDir = new File(uploadDirPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            if ("image/png".equals(file.getContentType())) {
                String uploadFileName = UUID.randomUUID() + originalFilename;
                File uploadFile = new File(uploadDirPath, uploadFileName);
                file.transferTo(uploadFile);
            } else {
                mv.addObject("msg", "Please upload a png file");
                mv.setViewName("upload-fail");
                return mv;
            }
        } else {
            mv.addObject("msg", "You need to select a file to upload");
            mv.setViewName("upload-fail");
            return mv;
        }

        mv.setViewName("upload-success");
        return mv;
    }
}
