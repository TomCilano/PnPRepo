package com.ironyard.controllers.rest;

import com.ironyard.data.UserMessageObJ;
import com.ironyard.repos.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Tom on 11/14/16.
 */
@RestController
@RequestMapping(path = "/rest/message")

public class RestMessageController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    public static DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm z");

    @Autowired
    private MessageRepository messageRepository;

    /**
     * This method takes in a UserMessageObJ and save it to the database.
     * Setting both the Id and the Date attributes automatically.
     *
     * @param aUserMessageObJ
     * @return A saved UserMessageObj
     */
    @RequestMapping(value = "/save_Message", method = RequestMethod.POST)
    private UserMessageObJ save(@RequestBody UserMessageObJ aUserMessageObJ) {
        Date date = new Date();
        log.debug("Creating a new userMessageObj");
        messageRepository.save(aUserMessageObJ);
        UserMessageObJ foundOne = messageRepository.findOne(aUserMessageObJ.getId());
        log.debug("Setting current date...");
        foundOne.setDate(sdf.format(date));
        messageRepository.save(foundOne);
        log.debug("userMessageObj saved with Id# "+ foundOne.getId()+ ", date set to "+ foundOne.getDate());
        log.debug("POST request completed successfully");
        return foundOne;
    }

    /**
     * This method gets a particular UserMessageObj by it's Id
     *
     * @param id
     * @return A UserMessageObJ
     */
    @RequestMapping(value = "get{id}", method = RequestMethod.GET)
    public UserMessageObJ get(@PathVariable long id) {
        log.debug("Getting message by Id # " + id);
        UserMessageObJ found = messageRepository.findOne(id);
        log.debug("Retrieved Id# " + id);
        log.debug("GET request 'get' completed successfully");

        return found;
    }

    /**
     * This method edits a userMessage Object. It requires the user of the API to replace the
     * Id of the Swagger model with the Id of the UserMessageObj they intend to update. Altering
     * the Date String is futile as it is hard-set in the edit() to the local time of the server
     * it's running on.
     *
     * @param userMessageObJ
     * @return An edited UserMessageObj, with an updated date as well as the reference to the fact
     * the message has been edited
     */
    @RequestMapping(value = "edit", method = RequestMethod.PUT)
    public UserMessageObJ edit(@RequestBody UserMessageObJ userMessageObJ) {
        Date date = new Date();
        log.debug("Saving userMessageObj");
        messageRepository.save(userMessageObJ);
        UserMessageObJ foundOne = messageRepository.findOne(userMessageObJ.getId());
        log.debug("Found userMessageObj with Id# " + foundOne.getId());
        foundOne.setDate("Date Edited: " + sdf.format(date));
        log.debug("Set date of MessageObj with Id# " + foundOne.getId()+" to " + foundOne.getDate());
        messageRepository.save(foundOne);
        log.debug("Saved userMessage Obj with Id# " + foundOne.getId());
        log.debug("PUT Request 'edit' completed successfully");
        return foundOne;

    }

    /**
     * Lists paginated UserMessageObjs. It requires two parameters, page number and size.
     * There are two additional parameters: 'sortby', which allows the user to choose a
     * UserMessageObj attribute from which to sort (the default being its generated Id,)
     * and 'dir', which allows the user to sort the list in either an ascending or descending
     * direction(which by default is det to descending.)
     *
     * @param page
     * @param size
     * @param sortby
     * @param direction
     * @return A paginated list of all UserMessageObjs with respect the given parameters.
     */
    @RequestMapping(value = "listPageSize", method = RequestMethod.GET)
    public Iterable<UserMessageObJ> listByPage(@RequestParam("page") Integer page,
                                               @RequestParam("size") Integer size,
                                               @RequestParam(value = "sortby", required = false) String sortby,
                                               @RequestParam(value = "dir", required = false) Sort.Direction direction) {

        log.debug(String.format("Begin listAll (page:%s, size:%s, sortby:%s, dir:%s):", page, size, sortby, direction));

        // DEFAULT Sort property
        if (sortby == null) {
            sortby = "id";
        }

        // DEFAULT Sort direction
        if (direction == null) {
            direction = Sort.Direction.DESC;
        }
        Sort s = new Sort(direction, sortby);
        PageRequest pr = new PageRequest(page, size, s);
        Iterable<UserMessageObJ> found = messageRepository.findAll(pr);
        log.debug(String.format("End listAll: %s", found));
        log.debug("GET request 'listByPage' completed successfully");
        return found;
    }

    /**
     * This method simply list all UserMessageObJs currently persisted to the database.
     *
     * @return All UserMessageObJ
     */
    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    public Iterable<UserMessageObJ> listAll() {

        log.debug("Listing all messages");
        Iterable<UserMessageObJ> foundAll = messageRepository.findAll();
        log.debug("Messages found");
        log.debug("GET request 'listAll' completed successfully");
        return foundAll;
    }

    /**
     * This method finds a UserMessageObJ by it's unique Id and deletes it from the
     * database.
     * @param userMessageObJ
     * @return null[]
     */
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public UserMessageObJ delete(@RequestParam UserMessageObJ userMessageObJ) {
        log.debug("Deleting " + userMessageObJ.getId());
        messageRepository.delete(userMessageObJ);
        UserMessageObJ deletedOne = messageRepository.findOne(userMessageObJ.getId());
        log.debug("UserMessageObJ deleted");
        log.debug("DELETE request 'delete' completed successfully");
        return deletedOne;
    }
}
