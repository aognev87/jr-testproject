package ru.aognev.jrtestproject.dao;

import java.util.List;
import java.util.Map;

import ru.aognev.jrtestproject.model.User;

public interface UserDao {
    public void add(User user);

    public void edit(User user);

    public void delete(int userId);

    public User getUser(int userId);

    public List getUserByQuery(String name);

    public List getUserByMapQuery(Map<String, Object> map);

    public List getAllUser();
}