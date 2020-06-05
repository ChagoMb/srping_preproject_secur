package app.dao;

import app.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    User findUserByAuth(String email, String password);
    void addUser(User user);
    void removeUser(long id);
    void updateUser(long id, User user);
    User findUserById(long id);
    User findUserByUsername(String email);
}