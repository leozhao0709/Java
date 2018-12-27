package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller()
public class HelloController {
    @RequestMapping(value = {"/hello.do", "/welcome.do"}, method = RequestMethod.POST)
    public ModelAndView reqPost(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("hello", "hello Post springMVC");
        mv.setViewName("hello");

        return mv;
    }

    @RequestMapping(value = {"/hello.do", "/welcome.do"}, method = RequestMethod.GET)
    public ModelAndView reqGet() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("hello", "hello Get springMVC");
        mv.setViewName("hello");

        return mv;
    }

}
