package com.koop.moviesapp.usersapi.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserDto user) {
        log.info("IN UserService createUser {}", user);
        return userRepository.save(UserMapper.INSTANCE.userDtoToUser(user));
    }
    public User getUser(Integer id) {
        log.info("IN UserService getUser {}", id);
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

}
