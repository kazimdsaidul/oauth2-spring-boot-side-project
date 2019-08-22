package com.marcusdacoregio.authservice.service;

import com.marcusdacoregio.authservice.domain.UserEntity;
import com.marcusdacoregio.authservice.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity create(UserEntity user) {
        //throwIfUsernameExists(user.getUsername());

        String hash = passwordEncoder.encode(user.getPasssword());
        user.setPasssword(hash);
        user.setActivated(Boolean.TRUE); // TODO send sms or email with code for activation
//        user.setAuthorities(new HashSet<>(Collections.singletonList(Authorities.ROLE_USER)));

        // TODO other routines on account creation

        return userRepository.save(user);
    }

//    private void throwIfUsernameExists(String username) {
//        Optional<User> existingUser = userRepository.findByUsername(username);
//        existingUser.ifPresent((user) -> {
//            throw new IllegalArgumentException("User not available");
//        });
//    }

}
