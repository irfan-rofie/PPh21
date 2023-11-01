/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.pph21.service;

import java.util.List;
import spring.pph21.dao.UserDao;
import spring.pph21.model.User;

/**
 *
 * @author labprog1_7
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getUser(String username, String password) {
        return userDao.getUser(username, password);
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User getId(int id) {
        return userDao.getId(id);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public List viewUser() {
        return userDao.viewUser();
    }

}
