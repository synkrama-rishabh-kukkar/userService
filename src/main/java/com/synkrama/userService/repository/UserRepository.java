package com.synkrama.userService.repository;

import com.synkrama.userService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllUserIdByUserRoleAndUserIsActive(Long userRole, Boolean isActive);

    Optional<User> findByUserContact(String userContact);

    Optional<User> findByUserContactAndUserIsActive(String userContact, Boolean isActive);
}
