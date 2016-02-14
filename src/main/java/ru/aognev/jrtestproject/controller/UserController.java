package ru.aognev.jrtestproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import ru.aognev.jrtestproject.model.Page;
import ru.aognev.jrtestproject.model.User;
import ru.aognev.jrtestproject.service.UserService;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public ModelAndView slashInitialize() {
        userService.fillDB();
        return new ModelAndView("start");
    }

    @RequestMapping("index")
    public ModelAndView indexInitialize() {
        userService.fillDB();
        return new ModelAndView("start");
    }

    @RequestMapping("start")
    public ModelAndView getStart() {
        return new ModelAndView("start");
    }

    @RequestMapping("startAction")
    public ModelAndView getStartAction(@RequestParam String action) {
        switch (action.toLowerCase()) {
            case "add a new user":
                return new ModelAndView("redirect:form");

            case "search form":
                return new ModelAndView("redirect:searchForm");

            case "show all users":
                return new ModelAndView("redirect:list");

            default:
                return new ModelAndView("start");
        }
    }

    @RequestMapping("form")
    public ModelAndView getForm() {
        return new ModelAndView("form", "user", new User());
    }

    @RequestMapping("register")
    public ModelAndView registerUser(@ModelAttribute User user) {
        userService.add(user);
        return new ModelAndView("redirect:start");
    }

    @RequestMapping("list")
    public ModelAndView getList() {
        return new ModelAndView("list", userService.produceList(new Page("1")));
    }


    @RequestMapping("searchForm")
    public ModelAndView searchPage() {
        return new ModelAndView("searchform", "page", new Page());
    }


    @RequestMapping("listAction")
    public ModelAndView produceList(@ModelAttribute Page page) {
        if (page.getDelete() > 0)
            userService.delete(page.getUserId());

        if (page.getUpdate() > 0)
            return new ModelAndView("edit", "page", page);

        return new ModelAndView("list", userService.produceList(page));
    }

    @RequestMapping("searchListAction")
    public ModelAndView produceSearchList(@ModelAttribute Page page) {
        if (page.getDelete() > 0)
            userService.delete(page.getUserId());

        if (page.getUpdate() > 0)
            return new ModelAndView("edit", "page", page);

        return new ModelAndView("searchlist", userService.produceSearchList(page));
    }

    @RequestMapping("update")
    public ModelAndView updateUser(@ModelAttribute Page page) {
        User user = page.getUser();
        User originalUser = userService.getUser(user.getUserId());
        page.setUserData(originalUser);
        userService.edit(user);

        if (page.getCheckedName() > 0 || page.getCheckedAge() > 0 || page.getCheckedAdmin() > 0) {
            return new ModelAndView("searchlist", userService.produceSearchList(page));
        }

        List fullUserList = userService.getAllUser();
        return new ModelAndView("list", userService.produceList(page));

    }

}