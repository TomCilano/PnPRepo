package com.ironyard.controllers.rest;

import com.ironyard.data.UserObj;
import com.ironyard.repos.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * Saves a userObj
     *
     * @param aUserObj
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    private UserObj save(@RequestBody UserObj aUserObj) {
        log.debug("Initializing Save" + aUserObj);
        userRepository.save(aUserObj);
        UserObj foundOne = userRepository.findOne(aUserObj.getId());
        log.debug(aUserObj + "Save complete");
        return foundOne;
    }

    /**
     * get a user by its unique Id
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "get{id}", method = RequestMethod.GET)
    private UserObj show(@PathVariable Long id) {
        log.debug("Getting user with id # " + id);
        UserObj foundOne = userRepository.findOne(id);
        log.debug("Got user with id # " + id);
        return foundOne;
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    private UserObj update(@RequestBody UserObj aUserObj) {
        log.debug("Updating " + aUserObj);
        userRepository.save(aUserObj);
        UserObj foundOne = userRepository.findOne(aUserObj.getId());
        log.debug("Sucseffully updated " + aUserObj);
        return foundOne;
    }
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    private UserObj delete(@RequestParam UserObj aUserObj){
        userRepository.delete(aUserObj);
        UserObj deletedOne = userRepository.findOne(aUserObj.getId());

        return deletedOne;
    }
}
