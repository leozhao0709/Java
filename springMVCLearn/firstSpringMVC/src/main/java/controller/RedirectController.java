package controller;

import bean.School;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
class RedirectController {
    @RequestMapping("/redirectMAV")
    public ModelAndView redirectMAV(School school, String name){

        ModelAndView mv = new ModelAndView();

        //在重定向中可以使用ModelAndView传递数据，但是只能传递基本数据类型和String类型
        mv.addObject("school",school);
        mv.addObject("name", name);

        //使用重定向，此时springmvc.xml配置文件中的视图解析器将会失效
        mv.setViewName("redirect:/jsp/result.jsp");
        return mv;
    }
}
