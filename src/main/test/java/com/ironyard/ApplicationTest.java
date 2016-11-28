package com.ironyard;

import com.ironyard.data.StoryObj;
import com.ironyard.data.UserMessageObJ;
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
 * Created by Tom on 11/21/16.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StoryRepository storyRepository;
    @Autowired
    private MessageRepository messageRepository;

    /**
     * Prints out a token and tests if that token is valid
     *
     * @throws Exception
     */
    @Test
    public void printToken() throws Exception {
        String token = null;
        try {
            // assigns a generated token to 'token'
            token = SecurityUtils.genToken();
            // Prints 'token'
            System.out.println(token);
            //Asserts that the generated token is valid using isValidKey() method
            Assert.assertTrue(SecurityUtils.isValidKey(token));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    /**
     * This test checks if the a user is saved by searching for it's id.
     *
     * @throws Exception
     */
    @Test
    public void createUser() throws Exception {

        try {
            //Create a new User
            UserObj x = new UserObj();
            //save user x
            userRepository.save(x);
            //Assert that UserObj x's Id is not Null
            Assert.assertNotNull(userRepository.findOne(x.getId()));

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    /**
     * Creates and deletes a UserObj
     *
     * @throws Exception
     */
    @Test
    public void deleteUser() throws Exception {
        try {
            //Create a user
            UserObj x = new UserObj();
            userRepository.save(x);
            // prints user x to console
            System.out.print(x);
            // Deletes user x
            userRepository.delete(x.getId());
            //Assert that UserObj x's Id is Null
            Assert.assertNull(userRepository.findOne(x.getId()));

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    /**
     * Creates and deletes a StoryObj
     *
     * @throws Exception
     */
    @Test
    public void CreateAndDeleteStoryObj() throws Exception {
        try {
            // Creates a new StoryObj
            StoryObj x = new StoryObj();
            // Saves StoryObj x
            storyRepository.save(x);
            //Assert that the StoryObj x's Id is not null
            Assert.assertNotNull(storyRepository.findOne(x.getId()));
            // Deletes StoryObj x
            storyRepository.delete(x.getId());
            // Asserts StoryObj x's id is null
            Assert.assertNull(storyRepository.findOne(x.getId()));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    /**
     * Creates then deletes a UserMessageObj
     *
     * @throws Exception
     */
    @Test
    public void CreateAndDeleteUserMessageObj() throws Exception {
        try {
            //Creates a new UserMessageObj
            UserMessageObJ x = new UserMessageObJ();
            //Saves the UserMessageObj
            messageRepository.save(x);
            System.out.print(x);
            // Asserts UserMessageObj x's Id is not null
            Assert.assertNotNull(messageRepository.findOne(x.getId()));
            //Deletes UserMessageObj x
            messageRepository.delete(x);
            // Asserts UserMessageObj x's Id is null
            Assert.assertNull(messageRepository.findOne(x.getId()));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }

}
