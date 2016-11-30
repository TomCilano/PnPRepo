package com.ironyard.controllers.rest;

import com.ironyard.data.UserMessageObJ;
import com.ironyard.data.UserObj;
import com.ironyard.repos.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.ironyard.generation.NameGenerator.generateName;

/**
 * Created by Tom on 11/8/16.
 */
@RestController
@RequestMapping(path = "/rest/aUser")
public class RestUserController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    public static DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm z");
    Date date = new Date();

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
        log.debug("Setting date");
        for (UserMessageObJ m : aUserObj.getUserMessageObJSet()) {
            m.setDate(sdf.format(date));
        }
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
        log.debug("Successfully updated " + aUserObj);
        log.debug("PUT request update completed successfully");
        return foundOne;
    }

    /**
     * This method finds a UserObj by it's unique Id and deletes it from the
     * database.
     *
     * @param aUserObjId
     * @return nul []
     */
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public UserObj delete(@RequestParam UserObj aUserObjId) {
        log.debug("Deleting " + aUserObjId);
        userRepository.delete(aUserObjId);
        UserObj deletedOne = userRepository.findOne(aUserObjId.getId());
        log.debug(aUserObjId + "with Id# " + " deleted");
        log.debug("DELETE request 'delete' completed successfully");

        return deletedOne;
    }

    /**
     * This method currently creates a user and generates its name using the generateName() from
     * the Name Generator class. It will eventually randomize the entirety of a UserObj
     *
     * @param aUserObj
     * @return A userObj with Generated values
     */
    @RequestMapping(value = "Generate", method = RequestMethod.POST)
    public UserObj GenerateUser(@RequestBody UserObj aUserObj) {
        log.debug("Generating a UserObj");
        userRepository.save(aUserObj);
        UserObj created = userRepository.findOne(aUserObj.getId());
        log.debug("generating Username");
        String generatedName = generateName();
        aUserObj.setUserName(generatedName);
        log.debug("Iterating through UserMessageSet");
        for (UserMessageObJ m : aUserObj.getUserMessageObJSet()) {
            m.setDate(sdf.format(date));
        }
        log.debug("Message date set.");
        log.debug("Saving userObj");
        userRepository.save(created);
        log.debug("POST request GenerateUser completed successfully");
        return created;
    }
}