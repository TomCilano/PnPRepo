package com.ironyard.repos;

import com.ironyard.data.StoryObj;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Tom on 11/15/16.
 */
public interface StoryRepository extends PagingAndSortingRepository<StoryObj,Long> {
}
