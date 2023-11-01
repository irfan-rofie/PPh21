/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.pph21.dao;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import spring.pph21.model.User;

/**
 *
 * @author labprog1_7
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    @Override
    public List<User> getUser(String username, String password) {
        return getHibernateTemplate().find("from User where username='" + username + "' and password='" + password + "'");
    }

    @Override
    public void saveUser(User user) {
        getHibernateTemplate().saveOrUpdate(user);
    }

    @Override
    public User getId(int id) {
        return (User) getHibernateTemplate().get(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        getHibernateTemplate().delete(getId(id));
    }

    @Override
    public List viewUser() {
        return getHibernateTemplate().find("from User");
    }

}
