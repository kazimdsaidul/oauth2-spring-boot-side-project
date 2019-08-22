package com.marcusdacoregio.authservice.controller;

import com.marcusdacoregio.authservice.domain.UserEntity;
import com.marcusdacoregio.authservice.dto.UserDto;
import com.marcusdacoregio.authservice.dto.UserRegistrationDto;
import com.marcusdacoregio.authservice.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/current")
    public Principal getUser(Principal principal) {
        return principal;
    }

    @PostMapping
//    @PreAuthorize("#oauth2.hasScope('server')")
    public UserDto createUser(@Valid @RequestBody UserRegistrationDto userRegistration) {
        UserEntity savedUser = userService.create(toUser(userRegistration));
        return toDto(savedUser);
    }

    private UserDto toDto(UserEntity user) {
        UserDto userDto = new UserDto();
//        userDto.setId(user.getId());
        userDto.setUsername(user.getId());
        return userDto;
    }

    private UserEntity toUser(UserRegistrationDto userRegistration) {
        UserEntity user = new UserEntity();
        user.setUsername(userRegistration.getUsername());
        user.setPasssword(userRegistration.getPassword());
        return user;
    }

}
