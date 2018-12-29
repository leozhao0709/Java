package controllers;

import bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
class UserController {

    @RequestMapping("/register")
    public ModelAndView register(@Validated User user, BindingResult bindingResult) {
        ModelAndView mv = new ModelAndView();

        List<ObjectError> allErrors = bindingResult.getAllErrors();
        if (allErrors.size() > 0) {
            FieldError nameError = bindingResult.getFieldError("name");
            FieldError ageError = bindingResult.getFieldError("age");
            FieldError phoneError = bindingResult.getFieldError("phone");

             if (nameError != null) {
                mv.addObject("nameError", nameError.getDefaultMessage());
            }
            if (ageError != null) {
                mv.addObject("ageError", ageError.getDefaultMessage());
            }
            if (phoneError != null) {
                mv.addObject("phoneError", phoneError.getDefaultMessage());
            }

        }

        mv.setViewName("user");
        return mv;
    }
}
