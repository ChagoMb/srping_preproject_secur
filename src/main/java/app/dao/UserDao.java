package app.dao;

import app.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    User findUserByAuth(String email, String password);
    void addUser(User user);
    void removeUser(long id);
    void updateUser(long id, String firstName, String lastName, String password, String email, long bankAcc, String role);
    User findUserById(long id);
}