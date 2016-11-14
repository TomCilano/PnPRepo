package com.ironyard.controllers.rest;

import com.ironyard.data.UserMessage;
import com.ironyard.repos.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
     * @param userMessage
     * @return saved message
     */
    @RequestMapping(value ="/save_message", method = RequestMethod.GET)
    private UserMessage save(@RequestBody UserMessage userMessage){
        log.debug("creating a user message...");

        messageRepository.save(userMessage);
        UserMessage foundOne = messageRepository.findOne(userMessage.getId());

        log.debug("user message saved! Great success!");
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
}
