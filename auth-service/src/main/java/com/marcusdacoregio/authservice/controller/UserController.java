package com.marcusdacoregio.authservice.controller;

import com.marcusdacoregio.authservice.dto.UserDto;
import com.marcusdacoregio.authservice.dto.UserRegistrationDto;
import com.marcusdacoregio.authservice.model.AuthUserDetail;
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
        System.err.println("createUser");
        AuthUserDetail savedUser = userService.create(toUser(userRegistration));
        return toDto(savedUser);
    }

    private UserDto toDto(AuthUserDetail user) {
        UserDto userDto = new UserDto();
//        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        return userDto;
    }

    private AuthUserDetail toUser(UserRegistrationDto userRegistration) {
        AuthUserDetail user = new AuthUserDetail();
        user.setUsername(userRegistration.getUsername());
        user.setPassword(userRegistration.getPassword());
        return user;
    }

}
