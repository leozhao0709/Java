package controllers;

import exceptions.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
class ExceptionController {

    @RequestMapping("/exceptionHandler")
    public ModelAndView exceptionHandler(String name) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("normal");
        if ("jack".equals(name)) {
            throw new MyException("my Exception...");
        }
        else if ("james".equals(name)){
            throw new Exception("General exception...");
        }

        return mv;
    }
}
