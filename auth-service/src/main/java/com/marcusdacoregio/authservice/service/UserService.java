package com.marcusdacoregio.authservice.service;

import com.marcusdacoregio.authservice.model.AuthUserDetail;
import com.marcusdacoregio.authservice.model.User;

import java.util.Optional;

public interface UserService {
    User create(AuthUserDetail user);

    Optional<Optional<User>> findByUsername(String username);
}
