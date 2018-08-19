package com.greenfox.aze.reddit.redditapp.DTO;

import com.greenfox.aze.reddit.redditapp.models.Post;
import com.greenfox.aze.reddit.redditapp.models.User;

import java.time.LocalDateTime;
import java.util.List;

public class PostResponseDTO {

    private Long id;
    private String title;
    private String url;
    private Long score = 0L;
    private LocalDateTime timestamp;
    private String owner;
    private int vote;

    public PostResponseDTO() {

    }

    public PostResponseDTO(Post post, User user) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.url = post.getUrl();
        this.score = post.getScore();
        this.timestamp = post.getTimestamp();
        this.owner = user.getUsername();
        this.vote = vote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }
}
