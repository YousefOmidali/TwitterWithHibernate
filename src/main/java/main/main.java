package main;

import Entity.Account;
import Repository.*;

public class main {
    public static void main(String[] args) {
        AccountRepository accountRepository = new AccountRepository();
        CommentRepository commentRepository = new CommentRepository();
        LikeRepository likeRepository = new LikeRepository();
        DisLikeRepository disLikeRepository = new DisLikeRepository();
        ReplayRepository replayRepository = new ReplayRepository();
        TwitRepository twitRepository = new TwitRepository();


    }
}
