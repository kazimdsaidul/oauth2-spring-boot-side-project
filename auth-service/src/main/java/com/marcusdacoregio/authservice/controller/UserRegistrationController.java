package com.marcusdacoregio.authservice.controller;

import com.marcusdacoregio.authservice.model.respose.RegistrationRespose;
import com.marcusdacoregio.authservice.model.Permission;
import com.marcusdacoregio.authservice.model.Role;
import com.marcusdacoregio.authservice.model.User;
import com.marcusdacoregio.authservice.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;


@RestController
public class UserRegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object>  signup(@Valid @RequestBody User user, @RequestHeader HttpHeaders headers) {
        List<Permission> permissionList = new ArrayList<>();
        Permission readProfilePermission = new Permission(2, "read_profile");
        permissionList.add(readProfilePermission);

        List<Role> roleList = new ArrayList<>();
        Role userRole = new Role(3, "ROLE_user", permissionList);
        roleList.add(userRole);

        user.setRoles(roleList);

        User user1 = null;


        user1 = registrationService.addUser(user);
        RegistrationRespose registrationRespose = new RegistrationRespose();
        if (user1 !=null){
            user1.setPassword(null);
            registrationRespose.setMessage("User successfully registered and logged in");
            registrationRespose.setSuccess(true);
            registrationRespose.setStatus(200);
            registrationRespose.setData(user);
            return ResponseEntity.ok(registrationRespose);
        }else {
            registrationRespose.setMessage("Server error");
            registrationRespose.setSuccess(false);
            registrationRespose.setStatus(403);
            return ResponseEntity.ok(registrationRespose);
        }
    }

}
