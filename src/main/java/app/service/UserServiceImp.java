package app.service;

import app.dao.UserDao;
import app.model.Role;
import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service(value = "userService")
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
        dao.updateUser(id, user);
    }

    @Transactional
    @Override
    public User findUserById(long id) {
        return dao.findUserById(id);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return dao.findUserByUsername(s);
    }

    @Transactional
    @Override
    public UserDetails findUserByUsername(String email) {
        User user = dao.findUserByUsername(email);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        for(Role role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
    }
}
