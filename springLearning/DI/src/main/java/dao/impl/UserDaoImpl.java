package dao.impl;

import dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository("userDao")
class UserDaoImpl implements UserDao {

    @Override
    public void addUser() {
        System.out.println("add new user");
    }
}
