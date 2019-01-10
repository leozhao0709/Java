package services.impl;

import org.springframework.stereotype.Service;
import services.UserServices;

@Service("userServices")
class UserServicesImpl implements UserServices {

    @Override
    public void addUser() {
        System.out.println("执行service中的addUser方法");
    }

    @Override
    public void selectUserById(int id) throws Exception {
        System.out.println("执行service中的selectUserById方法");
        if (id == 0){
            throw new Exception();
        }
    }

    @Override
    public int updateUser() {
        System.out.println("执行service中的updateUser方法");

        return 1024;
    }

    @Override
    public void deleteUser() {
        System.out.println("执行service中的deleteUser方法");
    }

    @Override
    public void selectUser() {
        System.out.println("执行service中的selectUser方法");
    }
}
