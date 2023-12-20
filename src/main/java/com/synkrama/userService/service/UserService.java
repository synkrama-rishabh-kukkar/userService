package com.synkrama.userService.service;

import com.synkrama.userService.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<Object> findAll();

    ResponseEntity<Object> findById(Long userId);

    ResponseEntity<Object> save(User user);

    ResponseEntity<Object> update(User user);

    ResponseEntity<Object> delete(Long userId);

    ResponseEntity<Object> findAllByPaginated(Integer pageNumber, Integer pageSize);

}
