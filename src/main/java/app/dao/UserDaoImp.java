package app.dao;

import app.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Objects;

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
    @SuppressWarnings("unchecked")
    public void updateUser(long id, String firstName, String lastName, String password, String email, long bankAcc, String role) {
        String hql = "UPDATE User SET firstName = :user_firstName, lastName = :user_lastName," +
                " password = :user_password, email = :user_email, bankAcc = :user_acc," +
                " role = :user_role WHERE id = :user_id";
        Query<User> q = sessionFactory.getCurrentSession().createQuery(hql);
        q.setParameter("user_id", id);
        q.setParameter("user_firstName", firstName);
        q.setParameter("user_lastName", lastName);
        q.setParameter("user_password", password);
        q.setParameter("user_email", email);
        q.setParameter("user_acc", bankAcc);
        q.setParameter("user_role", role);
        q.executeUpdate();
    }

    @Override
    @SuppressWarnings("unchecked")
    public User findUserById(long id) {
        String hql = "FROM User WHERE id = :user_id";
        Query<User> q = sessionFactory.getCurrentSession().createQuery(hql);
        q.setParameter("user_id", id);
        return q.getSingleResult();
    }
}
