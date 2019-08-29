package com.marcusdacoregio.authservice.service;


import com.marcusdacoregio.authservice.model.User;
import com.marcusdacoregio.authservice.repository.UserDetailRepository;
import org.bouncycastle.math.ec.ScaleYPointMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Logger;

@Service
@Transactional
public class RegistrationService {

    @Autowired
    private UserDetailRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User addUser(User user) {
        User save = null;
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        try {

            save = userRepository.save(user);
        }
        catch (DataIntegrityViolationException e) {
            System.err.println(e.getLocalizedMessage());
        }
        return save;



    }


}
