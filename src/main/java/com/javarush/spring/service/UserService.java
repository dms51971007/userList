package com.javarush.spring.service;

import java.util.List;

import com.javarush.spring.model.Filter;
import com.javarush.spring.model.User;

public interface UserService {

    public void addUser(User p);
    public void updateUser(User p);
    public List<User> listUsers(int page, Filter flt);
    public int countPage(Filter flt);
    public User getUserById(int id);
    public void removeUser(int id);

}