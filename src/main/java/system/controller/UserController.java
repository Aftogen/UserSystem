package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import system.model.User;
import system.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    public ModelAndView validateUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userFromServer", new User());
        modelAndView.setViewName("user_check_page");
        return modelAndView;
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public @ResponseBody
    String checkUser(@ModelAttribute("userFromServer") User user) {

        for (User user1 : userService.getAllUsers()) {
            if (user1.getName().equals(user.getName()) && user1.getPassword().equals(user.getPassword()))
                return "valid";
        }

        return "invalid";
    }
}
/*
@RequestMapping(value = "/check", method = RequestMethod.POST)
    public @ResponseBody
    String checkUser(@ModelAttribute("userFromServer") User user) {

        for (User user1 : userService.getAllUsers()) {
            if (user1.getName().equals(user.getName()) && user1.getPassword().equals(user.getPassword()))
                return "valid";
        }

        return "invalid";
    }*/