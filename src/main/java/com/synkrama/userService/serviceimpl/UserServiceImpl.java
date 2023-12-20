package com.synkrama.userService.serviceimpl;

import com.synkrama.userService.entity.User;
import com.synkrama.userService.model.JsonResponse;
import com.synkrama.userService.repository.UserPaginatedRepository;
import com.synkrama.userService.repository.UserRepository;
import com.synkrama.userService.service.UserService;
import com.synkrama.userService.utils.constants.StringConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPaginatedRepository userPaginatedRepository;

    @Override
    public ResponseEntity<Object> findAll() {
        List<User> userList = userRepository.findAll();
        if (!userList.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(
                    JsonResponse.builder()
                            .statusCode(HttpStatus.OK.value())
                            .message(StringConstants.REQUEST_SUCCESS_MESSAGE_USER_FETCHED)
                            .status(HttpStatus.OK)
                            .data(userList)
                            .build());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                JsonResponse.builder()
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .message(StringConstants.REQUEST_FAILURE_MESSAGE_NO_USER_FOUND)
                        .status(HttpStatus.BAD_REQUEST)
                        .build());
    }

    @Override
    public ResponseEntity<Object> findById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent())
            return ResponseEntity.status(HttpStatus.OK).body(
                    JsonResponse.builder()
                            .statusCode(HttpStatus.OK.value())
                            .message(StringConstants.REQUEST_SUCCESS_MESSAGE_SELECTED_USER_FETCHED + userId)
                            .status(HttpStatus.OK)
                            .data(userOptional.get())
                            .build());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                JsonResponse.builder()
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .message(StringConstants.REQUEST_FAILURE_MESSAGE_NO_USER_FOUND)
                        .status(HttpStatus.BAD_REQUEST)
                        .build());
    }

    @Override
    public ResponseEntity<Object> save(User user) {
        Optional<User> optionalUser = userRepository.findByUserContactAndUserIsActive(user.getUserContact(), Boolean.TRUE);
        if (optionalUser.isEmpty()) {
            User savedUser = userRepository.save(user);
            if (savedUser != null) {
                return ResponseEntity.status(HttpStatus.OK).body(
                        JsonResponse.builder()
                                .statusCode(HttpStatus.OK.value())
                                .message(StringConstants.REQUEST_SUCCESS_MESSAGE_USER_CREATED)
                                .status(HttpStatus.OK)
                                .data(savedUser)
                                .build());
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                JsonResponse.builder()
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .message(StringConstants.REQUEST_FAILURE_MESSAGE_USER_NOT_CREATED)
                        .status(HttpStatus.BAD_REQUEST)
                        .build());
    }

    @Override
    public ResponseEntity<Object> update(User user) {
        Optional<User> optionalUser = userRepository.findById(user.getUserId());
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setUserName(user.getUserName());
            existingUser.setUserEmail(user.getUserEmail());
            existingUser.setUserImageUrl(user.getUserImageUrl());
            userRepository.save(existingUser);
            return ResponseEntity.status(HttpStatus.OK).body(
                    JsonResponse.builder()
                            .statusCode(HttpStatus.OK.value())
                            .message(StringConstants.REQUEST_SUCCESS_MESSAGE_USER_UPDATED)
                            .status(HttpStatus.OK)
                            .data(optionalUser)
                            .build());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                JsonResponse.builder()
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .message(StringConstants.REQUEST_FAILURE_MESSAGE_NO_USER_FOUND)
                        .status(HttpStatus.BAD_REQUEST)
                        .build());
    }

    @Override
    public ResponseEntity<Object> delete(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return ResponseEntity.status(HttpStatus.OK).body(
                    JsonResponse.builder()
                            .statusCode(HttpStatus.OK.value())
                            .message(StringConstants.REQUEST_SUCCESS_MESSAGE_USER_DELETED)
                            .status(HttpStatus.OK)
                            .build());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                JsonResponse.builder()
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .message(StringConstants.REQUEST_FAILURE_MESSAGE_NO_USER_FOUND)
                        .status(HttpStatus.BAD_REQUEST)
                        .build());
    }

    @Override
    public ResponseEntity<Object> findAllByPaginated(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        List<User> userList = userPaginatedRepository.findAll(pageable).toList();
        if (userList.isEmpty())
            return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                    .body(JsonResponse.builder()
                            .message(StringConstants.REQUEST_FAILURE_MESSAGE_NO_USER_FOUND)
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());

        return ResponseEntity.status((HttpStatus.OK))
                .body(JsonResponse.builder()
                        .data(userList)
                        .message(StringConstants.REQUEST_SUCCESS_MESSAGE_USER_FETCHED)
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());

    }
}
