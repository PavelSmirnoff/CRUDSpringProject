package dev.smirnov.crudspringproject.dao;

import dev.smirnov.crudspringproject.model.User;

import java.util.List;

/**
 * @author pavelsmirnov
 */
public interface UserDao {
    void createUser(User user);
    User getUserById(Long id);
    User getUserByName(String firstName);
    void updateUser(User user);
    void deleteUser(Long id);
    List<User> getUsers();
}
