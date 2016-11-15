package com.ironyard.repos;

import com.ironyard.data.UserMessage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Tom on 11/14/16.
 */
public interface MessageRepository extends PagingAndSortingRepository<UserMessage, Long> {
}
