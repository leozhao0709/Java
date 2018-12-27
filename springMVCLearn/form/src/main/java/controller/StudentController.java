package controller;

import bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
class StudentController {

    @RequestMapping("/studentInfo")
    public ModelAndView getStudentInfo(Student student, @RequestParam(name = "password") String password) {
        ModelAndView mv = new ModelAndView();

        mv.addObject(student);
        mv.addObject("password", password);
        mv.setViewName("studentInfo");
        return mv;
    }
}
