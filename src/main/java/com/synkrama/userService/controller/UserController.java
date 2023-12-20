package com.synkrama.userService.controller;

import com.synkrama.userService.entity.User;
import com.synkrama.userService.service.UserService;
import com.synkrama.userService.utils.constants.ApiConstants;
import com.synkrama.userService.utils.constants.IntegerConstants;
import com.synkrama.userService.utils.constants.StringConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return userService.findAll();
    }

    @GetMapping(ApiConstants.REQUEST_MAPPING_KEY_ID)
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/paginated")
    public ResponseEntity<Object> findAllByPaginated(
            @RequestParam(required = false, defaultValue = StringConstants.TEXT_EMPTY + IntegerConstants.DEFAULT_PAGE_NUMBER) Integer pageNumber,
            @RequestParam(required = false, defaultValue = StringConstants.TEXT_EMPTY + IntegerConstants.DEFAULT_PAGE_SIZE) Integer pageSize
    ) {
        return userService.findAllByPaginated(pageNumber, pageSize);
    }


    @PostMapping
    public ResponseEntity<Object> save(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping(ApiConstants.REQUEST_MAPPING_KEY_ID)
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return userService.delete(id);
    }

}
