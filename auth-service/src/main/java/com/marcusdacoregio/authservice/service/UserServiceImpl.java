package com.marcusdacoregio.authservice.service;

import com.marcusdacoregio.authservice.model.AuthUserDetail;
import com.marcusdacoregio.authservice.model.User;
import com.marcusdacoregio.authservice.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    UserDetailRepository userRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserDetailRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public AuthUserDetail create(AuthUserDetail user) {
        throwIfUsernameExists(user.getUsername());

        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
//        user.setAc(Boolean.TRUE); // TODO send sms or email with code for activation
//        user.setAuthorities(new HashSet<>(Collections.singletonList(Authorities.ROLE_USER)));

        // TODO other routines on account creation

        return userRepository.save(user);
    }

    public Optional<Optional<User>> findByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }

    private void throwIfUsernameExists(String username) {
        Optional<Optional<User>> existingUser = Optional.ofNullable(userRepository.findByUsername(username));
        existingUser.ifPresent((user) -> {
            throw new IllegalArgumentException("User not available");
        });
    }

}
