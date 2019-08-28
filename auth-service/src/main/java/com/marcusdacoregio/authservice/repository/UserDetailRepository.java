package com.marcusdacoregio.authservice.repository;


import com.marcusdacoregio.authservice.model.AuthUserDetail;
import com.marcusdacoregio.authservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UserDetailRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String name);

}
