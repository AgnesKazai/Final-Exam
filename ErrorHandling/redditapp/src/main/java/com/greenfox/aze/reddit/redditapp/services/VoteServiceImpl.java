package com.greenfox.aze.reddit.redditapp.services;

import com.greenfox.aze.reddit.redditapp.models.Post;
import com.greenfox.aze.reddit.redditapp.models.User;
import com.greenfox.aze.reddit.redditapp.models.Vote;
import com.greenfox.aze.reddit.redditapp.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
;

@Service
public class VoteServiceImpl implements VoteService {

    private final VoteRepository voteRepository;

    @Autowired
    public VoteServiceImpl(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @Override
    public Vote findByPostAndUser(Post post, User user) {
        return voteRepository.findByPostAndUser(post, user);
    }

    @Override
    public void save(Vote vote) {
        voteRepository.save(vote);
    }

    @Override
    public void delete(Vote vote) {
        voteRepository.delete(vote);
    }

    @Override
    public void upVoting(User user, Post post, Vote vote) {
        if(vote == null){
            Vote upVote = new Vote(user, post, 1);
            voteRepository.save(upVote);
//            post.setUser(user);
        } else if (vote.getVote() == -1){
            vote.setVote(1);
            voteRepository.save(vote);
        }
    }

    @Override
    public void downVoting(User user, Post post, Vote vote) {
        if(vote == null){
            Vote upVote = new Vote(user, post, -1);
            voteRepository.save(upVote);
            post.setUser(user);
        } else if (vote.getVote() == 1){
            vote.setVote(-1);
            voteRepository.save(vote);
        }
    }
}
