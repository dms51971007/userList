package com.javarush.spring.dao;

import java.util.List;

import com.javarush.spring.model.Filter;
import com.javarush.spring.model.User;

public interface UserDAO {

    public void addUser(User p);
    public void updateUser(User p);
    public List<User> listUsers(int page, Filter filter);
    public int countPage(Filter flt);
    public User getUserById(int id);
    public void removeUser(int id);
}