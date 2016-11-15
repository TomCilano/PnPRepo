package com.ironyard.controllers.rest;

import com.ironyard.data.Story;
import com.ironyard.data.UserMessage;
import com.ironyard.repos.StoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Tom on 11/15/16.
 */
@RestController
@RequestMapping(path = "/rest/story")
public class RestStoryController {
        private final Logger log = LoggerFactory.getLogger(this.getClass());

        @Autowired
        private StoryRepository storyRepository;

        @RequestMapping(value ="/save_story", method = RequestMethod.POST)
        private Story save(@RequestBody Story story){
            log.debug("creating a user message...");

            storyRepository.save(story);
            Story foundOne = storyRepository.findOne(story.getId());

            log.debug("user message saved.");
            return foundOne;
        }


        @RequestMapping(value ="get{id}", method = RequestMethod.GET)
        private Story get(@PathVariable long id ){
            log.debug("getthing message by id# " + id);
            Story found = storyRepository.findOne(id);
            log.debug("got id#" + id);
            return found;
        }


        @RequestMapping(value = "edit", method = RequestMethod.PUT)
        private Story edit(@RequestBody Story story){

            storyRepository.save(story);

            Story foundOne = storyRepository.findOne(story.getId());

            return foundOne;

        }

        @RequestMapping(value = "list", method = RequestMethod.GET)
        public Iterable<Story> listByPage(@RequestParam("page") Integer page,
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
            Iterable<Story> found = storyRepository.findAll(pr);
            log.debug(String.format("End listAll: %s", found));

            return found;
        }

    /**
     * List all Stories
     * @return
     */
    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    private Iterable<Story> listAll() {

        log.debug("List all messages" );
        Iterable<Story> foundAll = storyRepository.findAll();
        log.debug("messages found");
        return foundAll;
    }

        @RequestMapping(value = "delete", method = RequestMethod.DELETE)
        private Story delete(@RequestParam Story story) {
            storyRepository.delete(story);
            Story deletedOne = storyRepository.findOne(story.getId());
            return deletedOne;
        }
    }

