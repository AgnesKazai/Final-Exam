package com.greenfox.aze.reddit.redditapp.services;


import com.greenfox.aze.reddit.redditapp.models.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {

    User findUserByUsername(String name);

    void saveUser (User user);
}
