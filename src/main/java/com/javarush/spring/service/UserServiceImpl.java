package com.javarush.spring.service;

import java.util.List;

import com.javarush.spring.model.Filter;
import com.javarush.spring.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javarush.spring.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public void addUser(User p) {
        this.userDAO.addUser(p);
    }

    @Override
    @Transactional
    public void updateUser(User p) {
        this.userDAO.updateUser(p);
    }

    @Override
    @Transactional
    public List<User> listUsers(int page, Filter flt) {

        return this.userDAO.listUsers(page,flt);

    }

    @Override
    @Transactional
    public int countPage(Filter flt) {
        return this.userDAO.countPage(flt);
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return this.userDAO.getUserById(id);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        this.userDAO.removeUser(id);
    }

}