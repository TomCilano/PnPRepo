package com.ironyard.repos;

import com.ironyard.data.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Tom on 11/8/16.
 */
public interface UserRepository extends CrudRepository<User,Long> {
}
