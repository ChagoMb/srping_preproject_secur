package app.service;

import app.dao.UserDao;
import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao dao;

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    @Transactional
    @Override
    public User findUserByAuth(String email, String password) {
        return dao.findUserByAuth(email, password);
    }

    @Transactional
    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Transactional
    @Override
    public void removeUser(long id) {
        dao.removeUser(id);
    }

    @Transactional
    @Override
    public void updateUser(long id, User user) {
        dao.updateUser(id, user.getFirstName(), user.getLastName(), user.getPassword(), user.getEmail(), user.getBankAcc(), user.getRole());
    }

    @Transactional
    @Override
    public User findUserById(long id) {
        return dao.findUserById(id);
    }
}
