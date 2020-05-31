package app.service;

import app.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User findUserByAuth(String email, String password);
    void addUser(User user);
    void removeUser(long id);
    void updateUser(long id, User User);
    User findUserById(long id);
}
