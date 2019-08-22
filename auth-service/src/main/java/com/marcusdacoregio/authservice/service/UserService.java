package com.marcusdacoregio.authservice.service;

import com.marcusdacoregio.authservice.domain.UserEntity;

public interface UserService {
    UserEntity create(UserEntity user);
}
