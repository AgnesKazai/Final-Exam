package com.greenfox.aze.reddit.redditapp;

import com.greenfox.aze.reddit.redditapp.models.Post;
import com.greenfox.aze.reddit.redditapp.models.User;
import com.greenfox.aze.reddit.redditapp.repositories.PostRepository;
import com.greenfox.aze.reddit.redditapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedditappApplication implements CommandLineRunner {

    @Autowired
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public RedditappApplication(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(RedditappApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//      postRepository.save(new Post("LOL", "http://facebook.com"));
//      postRepository.save(new Post("Incredible!", "http://tweet.com"));
//      postRepository.save(new Post("Wowwwww", "http://twitter.com"));
//      postRepository.save(new Post("That is not trueeeee!!!", "http://facebook.com"));
//      postRepository.save(new Post("Dog is the best animal", "http://facebook.com"));
//      postRepository.save(new Post("Tinder memes", "http://tinder.com"));


        userRepository.save(new User("Johnny"));
        userRepository.save(new User("Mario"));
        userRepository.save(new User("Hanna"));
        userRepository.save(new User("George"));
        userRepository.save(new User("Timo"));
    }
}
