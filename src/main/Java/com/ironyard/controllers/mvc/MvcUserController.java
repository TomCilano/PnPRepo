package com.ironyard.controllers.mvc;

import com.ironyard.data.UserObj;
import com.ironyard.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Tom on 11/11/16.
 */
@Controller
@RequestMapping(path = "/mvc")
public class MvcUserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public String AllUsers(Model model) {
        String destination = "/user";
        Iterable<UserObj> allUsers = userRepository.findAll();
        model.addAttribute("users", allUsers);
        return destination;
    }
}
