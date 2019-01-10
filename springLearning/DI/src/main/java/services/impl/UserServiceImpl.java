package services.impl;

import dao.UserDao;
import org.springframework.stereotype.Service;
import services.UserService;

import javax.annotation.Resource;

@Service("userService")
class UserServiceImpl implements UserService {


    @Resource(name = "userDao")
    private UserDao userDao;


    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser() {
        this.userDao.addUser();
    }
}
