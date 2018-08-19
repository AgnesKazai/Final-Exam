package com.greenfox.aze.reddit.redditapp.repositories;

import com.greenfox.aze.reddit.redditapp.models.Post;
import com.greenfox.aze.reddit.redditapp.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findAll();

    List<Post> findPostsById(Long id);

    List<Post> findPostsByUser (User user);


}
