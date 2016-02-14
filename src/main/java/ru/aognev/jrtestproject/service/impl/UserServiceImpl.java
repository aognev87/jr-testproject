package ru.aognev.jrtestproject.service.impl;

import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.aognev.jrtestproject.dao.UserDao;
import ru.aognev.jrtestproject.model.Page;
import ru.aognev.jrtestproject.model.User;
import ru.aognev.jrtestproject.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void add(User user) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        user.setCreatedDate(simpleDateFormat.format(new Date()));

        userDao.add(user);
    }

    @Transactional
    public void edit(User user) {
        userDao.edit(user);
    }

    @Transactional
    public void delete(int userId) {
        userDao.delete(userId);
    }

    @Transactional
    public User getUser(int userId) {
        return userDao.getUser(userId);
    }

    @Transactional
    public List getAllUser() {
        return userDao.getAllUser();
    }

    @Transactional
    public List getUserByQuery(String name) {
        return userDao.getUserByQuery(name);
    }

    @Transactional
    public List getUserByMapQuery(Map<String, Object> map) {
        return userDao.getUserByMapQuery(map);
    }

    @Transactional
    public Map<String, Object> produceList(Page page) {
        List fullUserList = getAllUser();
        return createModelMap(fullUserList, page);
    }

    @Transactional
    public Map<String, Object> produceSearchList(Page page) {
        return createRequestMap(page);
    }

    @Transactional
    public void addOnStart(User user) {
        userDao.add(user);
    }

    @Transactional
    private Map<String, Object> createRequestMap(Page page) {
        Map<String, Object> criteriaMap = new HashMap<>();

        String resultStr = "Search results by:";

        if (page.getCheckedName() > 0) {
            criteriaMap.put("name", page.getName());
            resultStr += String.format(" name '%s',", page.getName());
        }
        if (page.getCheckedAge() > 0) {
            criteriaMap.put("age", page.getAge());
            resultStr += String.format(" age '%d',", page.getAge());
        }
        if (page.getCheckedAdmin() > 0) {
            criteriaMap.put("isAdmin", page.getIsAdmin());
            String admin = page.getIsAdmin() == 0 ? "NO" : "YES";
            resultStr += String.format(" administrator  '%s',", admin);
        }

        if (resultStr.endsWith(","))
            resultStr = resultStr.substring(0, resultStr.length() - 1);
        else
            resultStr = "Search request was empty. Search results contains all users.";

        List searchList = getUserByMapQuery(criteriaMap);

        Map<String, Object> map = createModelMap(searchList, page);
        map.put("resultStr", resultStr);

        return map;
    }

    @Transactional
    private Map<String, Object> createModelMap(List fullUserList, Page page) {
        int rowsPerPage = page.getRowsPerPage();
        int pageNumber = -1;

        try {
            pageNumber = Integer.parseInt(page.getPageRequest());
        } catch (NumberFormatException nfe) {
        }

        List userList = null;

        int fullListSize = fullUserList.size();
        int pagesCount = fullListSize % rowsPerPage == 0 ? fullListSize / rowsPerPage : (fullListSize / rowsPerPage) + 1;
        pagesCount = pagesCount == 0 ? 1 : pagesCount;

        if (page.getPageRequest().equalsIgnoreCase("last"))
            pageNumber = pagesCount;

        pageNumber = pageNumber < 1 ? 1 : pageNumber;
        pageNumber = pageNumber > pagesCount ? pagesCount : pageNumber;

        int firstPage = pageNumber == 1 ? -1 : 1;
        int nextPage = pageNumber < pagesCount ? 1 : -1;
        int previousPage = pageNumber == 1 ? -1 : 1;
        int lastPage = pageNumber == pagesCount ? -1 : 1;

        int fromIndex = (pageNumber - 1) * rowsPerPage;
        int toIndex = pageNumber * rowsPerPage > fullListSize ? fullListSize : pageNumber * rowsPerPage;

        userList = fullUserList.subList(fromIndex, toIndex);

        Map<String, Object> map = new HashMap<>();
        page.setPage(pageNumber);

        map.put("page", page);
        map.put("pagesCount", pagesCount);
        map.put("pageNumber", pageNumber);
        map.put("rowsPerPage", rowsPerPage);
        map.put("firstPage", firstPage);
        map.put("nextPage", nextPage);
        map.put("previousPage", previousPage);
        map.put("lastPage", lastPage);
        map.put("userList", userList);
        return map;
    }

    @Transactional
    public void fillDB() {
        List userList = getAllUser();
        if (userList.size() < 500) {
            String[] names = new String[]{
                    "Gendalf", "Aragorn", "Elrond",
                    "Bilbo", "Legolas", "Gimli",
                    "Frodo", "Sam", "Pippin",
                    "Merry", "Boromir", "Faromir",
                    "Arven", "Galadriel", "Torin",
                    "Dvalin", "Balin", "Killy",
                    "Filly", "Dory", "Nory",
                    "Ory", "Owen", "Glowen",
                    "Biffur", "Boffur", "Bombur"
            };
            for (int i = 0; i < 938; i++) {
                String heroName = names[(int) (Math.random() * names.length)];
                int heroAge = (int) (Math.random() * 91) + 10;
                int heroAdmin = 0;

                if (heroAge > 19 && heroAge < 71) {
                    int chance = (int) (Math.random() * 3);

                    if (chance == 1)
                        heroAdmin = 1;
                }

                int year = 2016 - (int) (Math.random() * 21);
                int month = (int) (Math.random() * 13);
                month = month == 0 ? month + 1 : month;
                String sMonth = String.valueOf(month).length() == 1 ? "0".concat(String.valueOf(month)) : String.valueOf(month);

                int day = (int) (Math.random() * 28);
                day = day == 0 ? day + 1 : day;
                String sDay = String.valueOf(day).length() == 1 ? "0".concat(String.valueOf(day)) : String.valueOf(day);

                int hour = (int) (Math.random() * 24);
                String sHour = String.valueOf(hour).length() == 1 ? "0".concat(String.valueOf(hour)) : String.valueOf(hour);

                int minute = (int) (Math.random() * 60);
                String sMinute = String.valueOf(minute).length() == 1 ? "0".concat(String.valueOf(minute)) : String.valueOf(minute);

                int second = (int) (Math.random() * 60);
                String sSecond = String.valueOf(second).length() == 1 ? "0".concat(String.valueOf(second)) : String.valueOf(second);

                String date = String.format("%d-%s-%s %s:%s:%s", year, sMonth, sDay, sHour, sMinute, sSecond);

                User hero = new User();

                hero.setName(heroName);
                hero.setAge(heroAge);
                hero.setIsAdmin(heroAdmin);
                hero.setCreatedDate(date);
                addOnStart(hero);
            }
        }
    }
}
