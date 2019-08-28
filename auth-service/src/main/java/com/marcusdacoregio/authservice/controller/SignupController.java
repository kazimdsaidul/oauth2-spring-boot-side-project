package com.marcusdacoregio.authservice.controller;

import com.marcusdacoregio.authservice.model.Permission;
import com.marcusdacoregio.authservice.model.Role;
import com.marcusdacoregio.authservice.model.User;
import com.marcusdacoregio.authservice.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
public class SignupController {

    @Autowired
    private SignupService signupService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<String>  signup(@Valid @RequestBody User user, @RequestHeader HttpHeaders headers) {
        List<Permission> permissionList = new ArrayList<>();
        Permission readProfilePermission = new Permission(2, "read_profile");
        permissionList.add(readProfilePermission);

        List<Role> roleList = new ArrayList<>();
        Role userRole = new Role(3, "ROLE_user", permissionList);
        roleList.add(userRole);

        user.setRoles(roleList);

        signupService.addUser(user);

        return ResponseEntity.ok("signup");

    }

}
