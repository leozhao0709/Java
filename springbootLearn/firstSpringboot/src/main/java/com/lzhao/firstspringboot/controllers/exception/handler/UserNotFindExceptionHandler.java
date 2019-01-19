package com.lzhao.firstspringboot.controllers.exception.handler;

import com.lzhao.firstspringboot.exceptions.UserNotFindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

//@ControllerAdvice
class UserNotFindExceptionHandler {

    @ResponseBody
    @ExceptionHandler(UserNotFindException.class)
    public Map<String, Object> userNotFindException(Exception e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", "userNotFind");
        map.put("message", e.getMessage());
        return map;
    }
}
