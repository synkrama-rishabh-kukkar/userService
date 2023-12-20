package com.synkrama.userService.repository;

import com.synkrama.userService.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPaginatedRepository extends PagingAndSortingRepository<User, Long> {

}
