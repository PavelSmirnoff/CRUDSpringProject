package dev.smirnov.crudspringproject.dao;

import dev.smirnov.crudspringproject.model.Role;
import dev.smirnov.crudspringproject.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Locale;

/**
 * @author pavelsmirnov
 * @version 1.0
 * дата создания 02.03.2021
 */
@Repository
public class RoleDaoImpl implements RoleDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void createRole(Role role) {
        role.setName("ROLE_"+role.getName().toUpperCase(Locale.ROOT));
        em.persist(role);
    }

    @Override
    public void deleteRole(Long id) {
        em.remove(em.find(Role.class, id));
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Role> getRoles() {
        return em.createQuery("from Role", Role.class).getResultList();
    }
}
