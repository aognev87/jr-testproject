package ru.aognev.jrtestproject.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.aognev.jrtestproject.dao.UserDao;
import ru.aognev.jrtestproject.model.User;


@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        getSession().merge(user);
    }

    @Override
    public void edit(User user) {
        getSession().merge(user);
    }

    @Override
    public void delete(int userId) {
        getSession().delete(getUser(userId));
    }

    @Override
    public User getUser(int userId) {
        return (User) getSession().get(User.class, userId);
    }

    @Override
    public List getAllUser() {
        return getSession().createCriteria(User.class).list();
    }

    @Override
    public List getUserByQuery(String name) {
        return getSession().createCriteria(User.class).add(Restrictions.like("name", name)).list();
    }

    @Override
    public List getUserByMapQuery(Map<String, Object> map) {
        return getSession().createCriteria(User.class).add(Restrictions.allEq(map)).list();
    }

    private Session getSession() {
        Session sess = getSessionFactory().getCurrentSession();

        if (sess == null) {
            sess = getSessionFactory().openSession();
        }

        return sess;
    }

    private SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}