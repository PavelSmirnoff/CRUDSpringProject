package dev.smirnov.crudspringproject.service;

import dev.smirnov.crudspringproject.model.Role;

import java.util.List;

/**
 * @author pavelsmirnov
 * @version 1.0
 * дата создания 02.03.2021
 */
public interface RoleService {
    void createRole(Role role);
    void deleteRole(Long id);
    List<Role> getRoles();
    Role getRoleById(Long id);
}
