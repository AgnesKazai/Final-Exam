package com.greenfox.aze.reddit.redditapp.services;

import com.greenfox.aze.reddit.redditapp.models.Post;
import com.greenfox.aze.reddit.redditapp.models.User;
import com.greenfox.aze.reddit.redditapp.models.Vote;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VoteService {

    Vote findByPostAndUser(Post post, User user);

    void save (Vote vote);

    void delete (Vote vote);

    void upVoting (User user, Post post, Vote vote);

    void downVoting (User user, Post post, Vote vote);
}
