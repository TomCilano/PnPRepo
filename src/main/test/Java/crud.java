import com.ironyard.data.UserObj;
import com.ironyard.repos.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;

import static com.ironyard.security.SecurityUtils.genToken;

/**
 * Created by Tom on 11/11/16.
 */
@SpringBootTest
@RunWith(SpringRunner.class)

public class crud {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void getUserbyId() throws Exception{

        //Create a user with an Id
        UserObj testUser = userRepository.save(new UserObj());

        //find that user
       Object x = userRepository.findOne(testUser.getId());

        Assert.assertNotNull(x);

    }

    @Test
    public static void  main (String[] args){
        String token = null;
        try {
           token = genToken();
            System.out.print(token);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
