package com.ironyard;

import com.ironyard.data.UserObj;
import com.ironyard.repos.MessageRepository;
import com.ironyard.repos.StoryRepository;
import com.ironyard.repos.UserRepository;
import com.ironyard.security.SecurityUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



/**
 * Created by Tom on 11/11/16.
 */
@SpringBootTest
@RunWith(SpringRunner.class)

public class crud {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StoryRepository storyRepository;
    @Autowired
    private MessageRepository messageRepository;


    @Test
    public void printToken() throws Exception {
        String token = null;
        try {
            token = SecurityUtils.genToken();
            System.out.println(token);
            Assert.assertTrue(SecurityUtils.isValidKey(token));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }


    }
}
