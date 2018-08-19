package com.greenfox.aze.reddit.redditapp.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private String username;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Post> posts;

    @OneToMany (mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Vote> votes;


    public User() {
        posts = new ArrayList<>();
        votes = new ArrayList<>();
    }

    public User(String username) {
        this.username = username;
        posts = new ArrayList<>();
        votes = new ArrayList<>();
    }

    public void addVote(Vote vote){
        votes.add(vote);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }
}
