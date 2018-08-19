package com.greenfox.aze.reddit.redditapp.services;

import com.greenfox.aze.reddit.redditapp.models.Post;
import com.greenfox.aze.reddit.redditapp.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    void addPost(Post post);

    Post findPostById(Long id);

    List<Post> getAllPost();

    void increaseScoreOfPost(Long id);

    void decreaseScoreOfPost(Long id);

    void deletePost(Long id);

    void updatePost(Long id, Post postToUpdate);

    List<Post> getAllPostByUser(User user);
}
