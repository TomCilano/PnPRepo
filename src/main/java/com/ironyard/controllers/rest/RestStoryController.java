package com.ironyard.controllers.rest;

import com.ironyard.data.StoryObj;
import com.ironyard.repos.StoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Tom on 11/18/16.
 */
@RestController
@RequestMapping(path = "/rest/story")
public class RestStoryController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    public static DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm z");


    @Autowired
    private StoryRepository storyRepository;

    /**
     * This method takes in a StoryObj and save it to the database.
     * Setting both the Id and the Date attributes automatically.
     *
     * @param storyObj
     * @return A saved StoryObj
     */
    @RequestMapping(value = "/save_story", method = RequestMethod.POST)
    public StoryObj save(@RequestBody StoryObj storyObj) {

        Date date = new Date();
        log.debug("creating a StoryObj...*");
        storyRepository.save(storyObj);
        StoryObj foundOne = storyRepository.findOne(storyObj.getId());
        foundOne.setDate(sdf.format(date));
        log.debug("Saving StoryObj with sdf date format*");
        storyRepository.save(foundOne);
        log.debug("User message saved.");
        log.debug("POST request 'save' completed successfully");
        return foundOne;
    }

    /**
     * This method gets a particular StoryObj by it's Id
     *
     * @param id
     * @return A StoryObj
     */
    @RequestMapping(value = "get{id}", method = RequestMethod.GET)
    public StoryObj get(@PathVariable long id) {
        log.debug("Getting message by id# " + id);
        StoryObj found = storyRepository.findOne(id);
        log.debug("Got story with Id# " + id);
        log.debug("GET request 'get' completed successfully");

        return found;
    }

    /**
     * This method edits a StoryObj. It requires the user of the API to replace the
     * Id of the Swagger model with the Id of the StoryObj they intend to update. Altering
     * the Date String is futile as it is hard-set in the edit() to the local time of the server
     * it's running on.
     *
     * @param storyObj
     * @return An edited StoryObj, with an updated date as well as the reference to the fact
     * the message has been edited
     */
    @RequestMapping(value = "edit", method = RequestMethod.PUT)
    public StoryObj edit(@RequestBody StoryObj storyObj) {
        log.debug("Instantiating date*");
        Date date = new Date();
        log.debug("Finding StoryObj by Id*");
        StoryObj foundOne = storyRepository.findOne(storyObj.getId());
        foundOne.setDate("Edited on: " + sdf.format(date));
        storyRepository.save(foundOne);
        log.debug("Saved a StoryObj ");
        log.debug("PUT request 'edit' completed successfully");

        return foundOne;
    }

    /**
     * Lists paginated StoryObj. It requires two parameters, page number and size.
     * There are two additional parameters: 'sortby', which allows the user to choose a
     * StoryObj attribute from which to sort (the default being its generated Id,)
     * and 'dir', which allows the user to sort the list in either an ascending or descending
     * direction(which by default is det to descending.)
     *
     * @param page
     * @param size
     * @param sortby
     * @param direction
     * @return A paginated list of all StoryObj with respect the given parameters.
     */
    @RequestMapping(value = "listPageSize", method = RequestMethod.GET)
    public Iterable<StoryObj> listByPage(@RequestParam("page") Integer page,
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
        Iterable<StoryObj> found = storyRepository.findAll(pr);
        log.debug(String.format("End listAll: %s", found));
        log.debug("GET request 'listByPage' completed successfully");

        return found;
    }

    /**
     * This method simply list all StoryObj currently persisted to the database.
     *
     * @return All StoryObj
     */
    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    public Iterable<StoryObj> listAll() {

        log.debug("Listing all messages");
        Iterable<StoryObj> foundAll = storyRepository.findAll();
        log.debug("Messages found");
        log.debug("GET request 'listAll' completed successfully");

        return foundAll;
    }

    /**
     * This method finds a StoryObj by it's unique Id and deletes it from the
     * database.
     * @param storyObj
     * @return null[]
     */
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public StoryObj delete(@RequestParam StoryObj storyObj) {
        log.debug("Deleting a user by Id# " + storyObj.getId());
        storyRepository.delete(storyObj);
        log.debug("User with Id# " + storyObj.getId()+ " deleted");
        StoryObj deletedOne = storyRepository.findOne(storyObj.getId());
        log.debug("DELETE request 'delete' completed successfully");
        return deletedOne;
    }
}

