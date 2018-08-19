package com.greenfox.aze.reddit.redditapp.contollers;

import com.greenfox.aze.reddit.redditapp.DTO.ErrorMessage;
import com.greenfox.aze.reddit.redditapp.DTO.PostResponseDTO;
import com.greenfox.aze.reddit.redditapp.DTO.VoteResponseDTO;
import com.greenfox.aze.reddit.redditapp.models.*;
import com.greenfox.aze.reddit.redditapp.services.PostServiceImpl;
import com.greenfox.aze.reddit.redditapp.services.UserServiceImpl;
import com.greenfox.aze.reddit.redditapp.services.VoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin("*")
@RestController
public class PostsController {


    private final PostServiceImpl postService;
    private final VoteServiceImpl voteService;
    private final UserServiceImpl userService;

    @Autowired
    public PostsController(PostServiceImpl postService, VoteServiceImpl voteService, UserServiceImpl userService) {
        this.postService = postService;
        this.voteService = voteService;
        this.userService = userService;
    }

    @GetMapping("/posts")
    public List<PostResponseDTO> listingAllPosts(@RequestHeader(value = "username") String username) {
        User user = userService.findUserByUsername(username);
        List<Post> posts = postService.getAllPostByUser(user);
        List<PostResponseDTO> postResponseDTOS = new ArrayList<>();
        for (Post post : posts) {
            PostResponseDTO postResponseDTO = new PostResponseDTO(post, user);
            postResponseDTOS.add(postResponseDTO);
        }
        return postResponseDTOS;
    }

    @PostMapping("/posts")
    public Object addNewPost(@RequestHeader(value = "username") String username, @RequestBody Post newPost) {
        if (userService.findUserByUsername(username) != null) {
            User user = userService.findUserByUsername(username);
            newPost.setUser(user);
            postService.addPost(newPost);
            return new PostResponseDTO(newPost, user);
        } else {
            User user = new User(username);
            userService.saveUser(user);
            newPost.setUser(userService.findUserByUsername(username));
            postService.addPost(newPost);
            return new PostResponseDTO(newPost, user);
        }
    }

    @PutMapping("/posts/{id}/upvote")
    public VoteResponseDTO upVotePost(@RequestHeader(value = "username") String username, @PathVariable Long id) {
        User user = userService.findUserByUsername(username);
        Post post = postService.findPostById(id);
        Vote vote = voteService.findByPostAndUser(post, user);
        voteService.upVoting(user, post, vote);
        postService.increaseScoreOfPost(id);
        return new VoteResponseDTO(post, user);
    }

    @PutMapping("/posts/{id}/downvote")
    public List<Post> downVotePost(@RequestHeader(value = "username") String username, @PathVariable Long id) {
        User user = userService.findUserByUsername(username);
        Post post = postService.findPostById(id);
        Vote vote = voteService.findByPostAndUser(post, user);
        voteService.downVoting(user, post, vote);
        postService.decreaseScoreOfPost(id);
        return postService.getAllPost();
    }

    @DeleteMapping("/posts/{id}")
    public List<Post> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return postService.getAllPost();
    }

    @PutMapping("/posts/{id}")
    public List<Post> updatePost(@PathVariable Long id, @RequestBody Post postToUpdate) {
        postService.updatePost(id, postToUpdate);
        return postService.getAllPost();
    }

//    //Error handling to DELETE endpoint:
//    public List<Post> deletePost(@PathVariable Long id) throws NoPostAvailableException {
//        try {
//            Post post = postService.findPostById(id);
//            if (post != null) {
//                postService.deletePost(id);
//                return postService.getAllPost();
//            }
//        }catch(NoPostAvailableException e){
//               throw new NoPostAvailableException("Post not found");
//            }
//            return postService.getAllPost();
//        }
}
