package com.ironyard.Controllers.rest;

import com.ironyard.data.User;
import com.ironyard.repos.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Tom on 11/8/16.
 */
@RestController
@RequestMapping(path = "/rest/user")
public class UserController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "save", method = RequestMethod.POST)
    private User save(@RequestBody User aUser) {
        log.debug("Initializing Save" + aUser);
        userRepository.save(aUser);
        User foundOne = userRepository.findOne(aUser.getId());
        log.debug(aUser + "Save complete");
        return foundOne;
    }
    @RequestMapping(value = "get{id}", method = RequestMethod.GET)
    private User show(@PathVariable Long id){
        log.debug("Getting user with id # " + id);
        User foundOne = userRepository.findOne(id);
        log.debug("Got user with id # " + id);
        return foundOne;
    }
}
