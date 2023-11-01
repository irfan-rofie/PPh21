/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.pph21.dao;

import java.util.List;
import spring.pph21.model.User;

/**
 *
 * @author labprog1_7
 */
public interface UserDao {

    public List<User> getUser(String username, String password);

    public void saveUser(User user);

    public User getId(int id);

    public void deleteUser(int id);

    public List viewUser();
}
