package com.greenfox.aze.reddit.redditapp.services;

import com.greenfox.aze.reddit.redditapp.models.User;
import com.greenfox.aze.reddit.redditapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserByUsername(String name) {
        return userRepository.findUserByUsername(name);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
