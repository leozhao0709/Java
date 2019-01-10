package services;

public interface UserServices {
    void addUser();

    void selectUserById(int id)  throws Exception;

    int updateUser();

    void deleteUser();

    void selectUser();
}
