package com.lzhao.firstspringboot.exceptions;

public class UserNotFindException extends RuntimeException {

    public UserNotFindException() {
        super("用户不存在");
    }
}
