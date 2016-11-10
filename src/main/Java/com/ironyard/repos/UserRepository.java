package com.ironyard.repos;

import com.ironyard.data.UserObj;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Tom on 11/8/16.
 */
public interface UserRepository extends CrudRepository<UserObj,Long> {
}
