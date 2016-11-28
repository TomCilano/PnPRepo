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
 * Created by Tom on 11/15/16.
 */
@RestController
@RequestMapping(path = "/rest/story")
public class RestStoryController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    public static DateFormat sdf = new SimpleDateFormat("MM/dd/yyy hh:mm:ss");


    @Autowired
    private StoryRepository storyRepository;

    @RequestMapping(value = "/save_story", method = RequestMethod.POST)
    private StoryObj save(@RequestBody StoryObj storyObj) {

        Date date = new Date();
        log.debug("creating a StoryObj...*");
        StoryObj foundOne = storyRepository.findOne(storyObj.getId());
        foundOne.setDate(sdf.format(date));
        log.debug("Saving StoryObj with sdf date format*");
        storyRepository.save(foundOne);
        //    }

        log.debug("user message saved.");
        return foundOne;
    }


    @RequestMapping(value = "get{id}", method = RequestMethod.GET)
    private StoryObj get(@PathVariable long id) {
        log.debug("getting message by id# " + id);
        StoryObj found = storyRepository.findOne(id);
        log.debug("got story with id#" + id);
        return found;
    }

    /**
     * edits a storyObj, updates the date
     * @param storyObj
     * @return
     */
    @RequestMapping(value = "edit", method = RequestMethod.PUT)
    private StoryObj edit(@RequestBody StoryObj storyObj) {
        log.debug("Instantiating date*");
        Date date = new Date();
        log.debug("Finding StoryObj by Id*");
        StoryObj foundOne = storyRepository.findOne(storyObj.getId());
        foundOne.setDate("Edited on: " + sdf.format(date));
        storyRepository.save(foundOne);
        return foundOne;
    }

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

        return found;
    }

    /**
     * List all Stories
     *
     * @return
     */
    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    private Iterable<StoryObj> listAll() {

        log.debug("List all messages");
        Iterable<StoryObj> foundAll = storyRepository.findAll();
        log.debug("messages found");
        return foundAll;
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    private StoryObj delete(@RequestParam StoryObj storyObj) {
        storyRepository.delete(storyObj);
        StoryObj deletedOne = storyRepository.findOne(storyObj.getId());
        return deletedOne;
    }
}

