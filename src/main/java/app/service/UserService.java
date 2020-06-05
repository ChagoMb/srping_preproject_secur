package app.service;

import app.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAllUsers();
    User findUserByAuth(String email, String password);
    void addUser(User user);
    void removeUser(long id);
    void updateUser(long id, User User);
    User findUserById(long id);
    UserDetails findUserByUsername(String email);
}
