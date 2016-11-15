package com.ironyard.controllers.rest;

import com.ironyard.data.UserMessage;
import com.ironyard.data.UserObj;
import com.ironyard.repos.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Tom on 11/14/16.
 */
@RestController
@RequestMapping(path = "/rest/message")

public class RestMessageController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MessageRepository messageRepository;

    /**
     * Save a message
     * @param aUserMessage
     * @return saved message
     */
    @RequestMapping(value ="/save_message", method = RequestMethod.POST)
    private UserMessage save(@RequestBody UserMessage aUserMessage){
        log.debug("creating a user message...");

        messageRepository.save(aUserMessage);
        UserMessage foundOne = messageRepository.findOne(aUserMessage.getId());

        log.debug("user message saved.");
        return foundOne;
    }

    /**
     * get a message by it's unique Id
     * @param id
     * @return
     */
    @RequestMapping(value ="get{id}", method = RequestMethod.GET)
    private UserMessage get(@PathVariable long id ){
        log.debug("getthing message by id# " + id);
        UserMessage found = messageRepository.findOne(id);
        log.debug("got id#" + id);
        return found;
    }

    /**
     * edits a message
     * @param userMessage
     * @return
     */
    @RequestMapping(value = "edit", method = RequestMethod.PUT)
    private UserMessage edit(@RequestBody UserMessage userMessage){

        messageRepository.save(userMessage);

        UserMessage foundOne = messageRepository.findOne(userMessage.getId());

        return foundOne;

    }
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Iterable<UserMessage> listAll(@RequestParam("page") Integer page,
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
        Iterable<UserMessage> found = messageRepository.findAll(pr);
        log.debug(String.format("End listAll: %s", found));

        return found;
    }
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    private UserMessage delete(@RequestParam UserMessage userMessage) {
        messageRepository.delete(userMessage);
        UserMessage deletedOne = messageRepository.findOne(userMessage.getId());
        return deletedOne;
    }
}
