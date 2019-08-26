package com.marcusdacoregio.authservice.service;

import com.marcusdacoregio.authservice.model.AuthUserDetail;

public interface UserService {
    AuthUserDetail create(AuthUserDetail user);
}
