package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller()
@RequestMapping("/user")
class ParamsController {

    @RequestMapping("/params01")
    public ModelAndView getParams1(String username, int age) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("username", username);
        mv.addObject("age", age);
        mv.setViewName("result");

        return mv;
    }

    @RequestMapping("/params02")
    public ModelAndView getParams2(@RequestParam(name = "username") String name,
                                   @RequestParam(name = "age", defaultValue = "18") int newAge,
                                   @RequestParam(name = "password", required = false) String password) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("username", name);
        mv.addObject("age", newAge);
        mv.setViewName("result");

        return mv;
    }
}
