package com.greenfox.aze.reddit.redditapp.services;

import com.greenfox.aze.reddit.redditapp.models.Post;
import com.greenfox.aze.reddit.redditapp.models.User;
import com.greenfox.aze.reddit.redditapp.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public void addPost(Post post) {
        postRepository.save(post);
    }

    @Override
    public Post findPostById(Long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    @Override
    public void increaseScoreOfPost(Long id) {
        Post post = postRepository.findById(id).get();
        post.setScore(post.getScore() + 1);
        postRepository.save(post);
    }

    @Override
    public void decreaseScoreOfPost(Long id) {
        Post post = postRepository.findById(id).get();
        post.setScore(post.getScore() - 1);
        postRepository.save(post);
    }

    @Override
    public void deletePost(Long id) {
        Post post = postRepository.findById(id).get();
        postRepository.delete(post);
    }

    @Override
    public void updatePost(Long id, Post postToUpdate) {
        Post post = postRepository.findById(id).get();
        post.setTitle(postToUpdate.getTitle());
        post.setUrl(postToUpdate.getUrl());
        post.setTimestamp(LocalDateTime.now());
        postRepository.save(post);
    }

    @Override
    public List<Post> getAllPostByUser(User user) {
        return postRepository.findPostsByUser(user);
    }
}
