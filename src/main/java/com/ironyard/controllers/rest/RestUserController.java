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
public class RestUserController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    /**
     * This method takes in a UserObj and save it to the database.
     * Setting the Id automatically.
     *
     * @param aUserObj
     * @return A saved UserObj
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public UserObj save(@RequestBody UserObj aUserObj) {
        log.debug("Initializing Save" + aUserObj);
        userRepository.save(aUserObj);
        UserObj foundOne = userRepository.findOne(aUserObj.getId());
        log.debug(aUserObj + "Save complete");
        return foundOne;
    }

    /**
     * This method gets a particular UserObj by it's Id
     *
     * @param id
     * @return A UserObj
     */
    @RequestMapping(value = "get{id}", method = RequestMethod.GET)
    public UserObj show(@PathVariable Long id) {
        log.debug("Getting user with id # " + id);
        UserObj foundOne = userRepository.findOne(id);
        log.debug("Got user with id # " + id);
        return foundOne;
    }

    /**
     * Lists all UserObjs
     *
     * @return A list of all UserObjs
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Iterable<UserObj> listAll() {
        log.debug("List all users");
        Iterable<UserObj> foundAll = userRepository.findAll();
        log.debug("Users found");
        return foundAll;
    }

    /**
     * This method updates a UserObj. It requires the user of the API to replace the
     * Id of the Swagger model with the Id of the StoryObj they intend to update.
     *
     * @param aUserObj
     * @return An edited UserObj
     */
    @RequestMapping(value = "updateUserObJById", method = RequestMethod.PUT)
    public UserObj update(@RequestBody UserObj aUserObj) {
        log.debug("Updating " + aUserObj);
        userRepository.findOne(aUserObj.getId());
        userRepository.save(aUserObj);
        UserObj foundOne = userRepository.findOne(aUserObj.getId());
        log.debug("Sucseffully updated " + aUserObj);
        return foundOne;
    }

    /**
     * Deletes a user by it's unique Id
     *
     * @param aUserObjId
     * @return
     */
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public UserObj delete(@RequestParam UserObj aUserObjId) {
        log.debug("Deleting " + aUserObjId);
        userRepository.delete(aUserObjId);
        UserObj deletedOne = userRepository.findOne(aUserObjId.getId());
        log.debug(aUserObjId + "with Id# "+" deleted!");
        log.debug("DELETE request 'delete' completed successfully");

        return deletedOne;
    }
}