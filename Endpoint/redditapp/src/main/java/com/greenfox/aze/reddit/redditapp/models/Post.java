package com.greenfox.aze.reddit.redditapp.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String url;
    private LocalDateTime timestamp;
    private Long score = 0L;


    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany (mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Vote> votes;


    public Post() {
        this.timestamp = LocalDateTime.now();
        votes = new ArrayList<>();
    }

//    public Post(String title, String url, User author) {
//        this.title = title;
//        this.timestamp = LocalDateTime.now();
////        this.vote = getVote();
//        this.url = url;
////        this.owner = user.getUsername();
//    }
    public Post(String title, String url) {
        this.title = title;
        this.timestamp = LocalDateTime.now();
//        this.vote = getVote();
        this.url = url;

    }

    public int getActualPostsVote(User user){
        int vote = 0;
        for (int i = 0; i < getVotes().size() ; i++) {
            if (getVotes().get(i).getUser() == user){
                vote = getVotes().get(i).getVote();
            }

        }
        return vote;
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public User getUser() {
        return user;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public void setUser(User user) {
        this.user = user;
    }

}


