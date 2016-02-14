package ru.aognev.jrtestproject.service;

import java.util.List;
import java.util.Map;

import ru.aognev.jrtestproject.model.Page;
import ru.aognev.jrtestproject.model.User;

public interface UserService {
    public void add(User user);

    public void edit(User user);

    public void delete(int userId);

    public User getUser(int userId);

    public List getUserByQuery(String name);

    public List getUserByMapQuery(Map<String, Object> map);

    public List getAllUser();

    public void fillDB();

    public Map<String, Object> produceList(Page page);

    public Map<String, Object> produceSearchList(Page page);

}
