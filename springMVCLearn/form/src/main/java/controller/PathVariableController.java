package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
class PathVariableController {

    @RequestMapping("/{name}/{age}/register")
    public ModelAndView pathVariableTest(@PathVariable("name") String userName, @PathVariable int age) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("username", userName);
        mv.addObject("age", age);
        mv.setViewName("result");
        return mv;
    }
}
