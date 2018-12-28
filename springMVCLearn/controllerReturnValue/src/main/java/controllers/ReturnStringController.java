package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class ReturnStringController {

    @RequestMapping("/welcome")
    public String welcome() {
        // directly jump to welcome.jsp
        return "welcome";
    }

    @RequestMapping("/welcome2")
    public String welcome(String name, Model model) {

        model.addAttribute("username", name);
        return "welcome2";
    }

}
