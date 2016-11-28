package com.ironyard.controllers.rest;

import com.ironyard.data.UserMessageObJ;
import com.ironyard.repos.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.auditing.CurrentDateTimeProvider;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Tom on 11/14/16.
 */
@RestController
@RequestMapping(path = "/rest/message")

public class RestMessageController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    public static DateFormat sdf = new SimpleDateFormat("MM/dd/yyy hh:mm");

    @Autowired
    private MessageRepository messageRepository;

    /**
     * Save a message
     * @param aUserMessageObJ
     * @return saved message
     */
    @RequestMapping(value ="/saveMessage", method = RequestMethod.POST)
    private UserMessageObJ save(@RequestBody UserMessageObJ aUserMessageObJ){
        Date date = new Date();
        log.debug("creating a user message...");
        messageRepository.save(aUserMessageObJ);
        UserMessageObJ foundOne = messageRepository.findOne(aUserMessageObJ.getId());
        log.debug("Setting current date...");
        foundOne.setDate(sdf.format(date));
        messageRepository.save(foundOne);
        log.debug("user message saved, date set.");
        return foundOne;
    }

    /**
     * get a message by it's unique Id
     * @param id
     * @return
     */
    @RequestMapping(value ="get{id}", method = RequestMethod.GET)
    private UserMessageObJ get(@PathVariable long id ){
        log.debug("getthing message by id# " + id);
        UserMessageObJ found = messageRepository.findOne(id);
        log.debug("got id#" + id);
        return found;
    }

    /**
     * edits a message
     * @param userMessageObJ
     * @return
     */
    @RequestMapping(value = "edit", method = RequestMethod.PUT)
    private UserMessageObJ edit(@RequestBody UserMessageObJ userMessageObJ){
        Date date = new Date();
        messageRepository.save(userMessageObJ);
        UserMessageObJ foundOne = messageRepository.findOne(userMessageObJ.getId());
        foundOne.setDate("Date Edited: " + sdf.format(date));
        messageRepository.save(foundOne);

        return foundOne;

    }

    /**
     * Lists messages by page/size
     * @param page
     * @param size
     * @param sortby
     * @param direction
     * @return
     */
    @RequestMapping(value = "listPageSize", method = RequestMethod.GET)
    public Iterable<UserMessageObJ> listByPage(@RequestParam("page") Integer page,
                                               @RequestParam("size") Integer size,
                                               @RequestParam(value = "sortby", required = false) String sortby,
                                               @RequestParam(value = "dir", required = false) Sort.Direction direction) {

        log.debug(String.format("Begin listAll (page:%s, size:%s, sortby:%s, dir:%s):",page,size,sortby,direction));

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

        return found;
    }

    /**
     * List all Messages
     * @return
     */
    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    private Iterable<UserMessageObJ> listAll() {

        log.debug("List all messages" );
        Iterable<UserMessageObJ> foundAll = messageRepository.findAll();
        log.debug("messages found");
        return foundAll;
    }
    /**
     * Deletes user by their unique id
     * @param userMessageObJ
     * @return
     */
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    private UserMessageObJ delete(@RequestParam UserMessageObJ userMessageObJ) {
        log.debug("deleting "+ userMessageObJ.getId());
        messageRepository.delete(userMessageObJ);
        UserMessageObJ deletedOne = messageRepository.findOne(userMessageObJ.getId());
        log.debug("");
        return deletedOne;
    }
//    @RequestMapping(value="getByDate" , method=RequestMethod.GET)
//    public @ResponseBody UserMessageObJ fetchResult(@RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate) {
//        log.debug("Fetching message from date "+ fromDate );
//        UserMessageObJ x = messageRepository;
//    }
}
