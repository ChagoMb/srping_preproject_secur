package app.dao;

import app.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        String hql = "FROM User";
        return sessionFactory.getCurrentSession().createQuery(hql).getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public User findUserByAuth(String email, String password) {
        String hql = "FROM User u WHERE u.email = :user_email AND u.password = :user_password";
        Query<User> q = sessionFactory.getCurrentSession().createQuery(hql);
        q.setParameter("user_email", email);
        q.setParameter("user_password", password);
        if (q.list().isEmpty()) {
            return new User();
        }
        return q.getSingleResult();
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void removeUser(long id) {
        String hql = "DELETE FROM User WHERE id = :user_id";
        Query<User> q = sessionFactory.getCurrentSession().createQuery(hql);
        q.setParameter("user_id", id).executeUpdate();
    }

    @Override
    public void updateUser(long id, User user) {
        User u = new User(id, user.getFirstName(), user.getLastName(), user.getPassword(),
                user.getBankAcc(), user.getEmail(), user.getRoles());
        sessionFactory.getCurrentSession().update(u);
    }

    @Override
    @SuppressWarnings("unchecked")
    public User findUserById(long id) {
        String hql = "FROM User WHERE id = :user_id";
        Query<User> q = sessionFactory.getCurrentSession().createQuery(hql);
        q.setParameter("user_id", id);
        return q.getSingleResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public User findUserByUsername(String email) {
        String hql = "FROM User WHERE email = :user_email";
        Query<User> q = sessionFactory.getCurrentSession().createQuery(hql);
        q.setParameter("user_email", email);
        return q.getSingleResult();
    }
}
