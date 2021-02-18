package dev.smirnov.crudspringproject.service;

import dev.smirnov.crudspringproject.dao.UserDao;
import dev.smirnov.crudspringproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author pavelsmirnov
 */
@Service
public class UserServiceImpl implements UserService{
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void createUser(User user) {
        this.userDao.createUser(user);
    }

    @Override
    @Transactional
    public User getUserById(Long id) {
        return this.userDao.getUserById(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        this.userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        this.userDao.deleteUser(id);
    }

    @Override
    @Transactional
    public List<User> getUsers() {
        return this.userDao.getUsers();
    }
}
