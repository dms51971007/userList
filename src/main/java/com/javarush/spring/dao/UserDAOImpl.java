package com.javarush.spring.dao;

import java.util.List;

import com.javarush.spring.model.Filter;
import com.javarush.spring.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


@Repository
public class UserDAOImpl implements UserDAO {


    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addUser(User p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
    }

    @Override
    public void updateUser(User p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> listUsers(int page, Filter filter) {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User " + filter.toString()).setFirstResult(page*5).setMaxResults(5).list();
        return userList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public int countPage(Filter filter) {

        Session session = this.sessionFactory.getCurrentSession();
        int numRecords =  ((Long)session.createQuery("select count(*) from User " + filter.toString()).uniqueResult()).intValue();

        if (numRecords % 5 == 0) return numRecords / 5;
        else return (numRecords / 5) + 1;


    }


    @Override
    public User getUserById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User p = (User) session.load(User.class, new Integer(id));
        return p;
    }

    @Override
    public void removeUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User p = (User) session.load(User.class, new Integer(id));
        if(null != p){
            session.delete(p);
        }
    }

}