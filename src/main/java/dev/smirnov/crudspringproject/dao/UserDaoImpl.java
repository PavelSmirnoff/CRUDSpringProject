package dev.smirnov.crudspringproject.dao;

import dev.smirnov.crudspringproject.model.Role;
import dev.smirnov.crudspringproject.model.User;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;

/**
 * @author pavelsmirnov
 */
@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        return em.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void createUser(User user) {
        if(user.getRoles()==null) {
            user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        }
        em.persist(user);
    }

    @Override
    public User getUserById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public User getUserByName(String firstName) {
        User user = em.createQuery(
                "SELECT u from User u WHERE u.firstName = :firstName", User.class).
                setParameter("firstName", firstName).getSingleResult();
        return user;
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    public void deleteUser(Long id) {
        em.remove(em.find(User.class, id));
    }


}
