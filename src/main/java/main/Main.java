package main;

import Entity.*;
import Services.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        CommentService commentService = new CommentService();
        ReplayService replayService = new ReplayService();
        TwitService twitService = new TwitService();
        Scanner scanner = new Scanner(System.in);
        Account account;
        Account account2;
        List<Twit> twitList;
        List<Comment> commentList;
        Set<Account> followers;
        Set<Account> following;
        Long longId;
        Integer intId;
        String twitTxt;
        String commentTxt;
        Comment comment;
        Twit twit;
        Replay replay;
        String replayTxt;
        Integer role;
        Integer roleAfterLogin;
        String userName;
        String password;
        String fullName;
        Boolean loop = true;

        System.out.println("1.Login \n2.Signup ");
        role = scanner.nextInt();
        if (role == 1) {
            scanner.nextLine();
            System.out.println("enter your username: ");
            userName = scanner.nextLine();
            System.out.println("enter your password: ");
            password = scanner.nextLine();
            account = accountService.login(userName, password);
            while (loop) {
                if (account != null) {
                    System.out.println("1.show account \n2.edit account \n3.delete account  \n4.add a twit " +
                            "\n5.See a twit \n6.delete twit \n7.edit twit \n8.view all twits \n9.add a comment " +
                            "\n10.find all comments of a twit \n11.edit a comment \n12.delete a comment " +
                            "\n13.Like a twit \n14.disLike a twit \n15.see who are your following " +
                            "\n16.search an account by username \n17.follow an account " +
                            "\n18.see your followers \n19.Unfollow an account \n20.replay a comment " +
                            "\n21.see all replay of a comment \n22.Exit");
                    roleAfterLogin = scanner.nextInt();
                    switch (roleAfterLogin) {
                        case 1:
                            System.out.println("*********************************");
                            System.out.println("your id: "+account.getId());
                            System.out.println("your username: "+account.getUserName());
                            System.out.println("your fullName: "+account.getFullName());
                            System.out.println("*********************************");
                            break;
                        case 2:
                            scanner.nextLine();
                            System.out.println("enter your username: ");
                            userName = scanner.nextLine();
                            System.out.println("enter your password: ");
                            password = scanner.nextLine();
                            System.out.println("enter your fullName: ");
                            fullName = scanner.nextLine();
                            account = new Account(userName, password, fullName);
                            accountService.update(account);
                            System.out.println("done! ");
                            break;
                        case 3:
                            accountService.deleteById(account.getId());
                            break;
                        case 4:
                            scanner.nextLine();
                            System.out.println("enter your txt: ");
                            twitTxt = scanner.nextLine();
                            twit = new Twit(null, twitTxt, 0L, 0L, account);
                            twitService.save(twit);
                            System.out.println("done! ");
                            break;
                        case 5:
                            System.out.println("enter twit id: ");
                            longId = scanner.nextLong();
                            twit = twitService.findById(longId);
                            twit.getAccount().setPassword("Its personal! SORRY");
                            System.out.println(twit);
                            break;
                        case 6:
                            System.out.println("enter twit id: ");
                            longId = scanner.nextLong();
                            twitService.deleteById(longId);
                            System.out.println("deleted! ");
                            break;
                        case 7:
                            System.out.println("enter twit id: ");
                            twit = twitService.findById(scanner.nextLong());
                            System.out.println("enter new twit txt: ");
                            twit.setTwit(scanner.nextLine());
                            break;
                        case 8:
                            twitList = twitService.findAll();
                            twitList.forEach(System.out::println);
                            break;
                        case 9:
                            System.out.println("enter your id: ");
                            account = accountService.findById(scanner.nextLong());
                            System.out.println("enter twit id: ");
                            twit = twitService.findById(scanner.nextLong());
                            scanner.nextLine();
                            System.out.println("enter comment txt: ");
                            commentTxt = scanner.nextLine();
                            comment = new Comment(commentTxt, twit, account);
                            commentService.save(comment);
                            break;
                        case 10:
                            System.out.println("enter twit id: ");
                            longId = scanner.nextLong();
                            commentList = commentService.findAll(longId);
                            commentList.forEach(System.out::println);
                            break;
                        case 11:
                            System.out.println("enter comment id: ");
                            longId = scanner.nextLong();
                            comment = commentService.findById(longId);
                            scanner.nextLine();
                            System.out.println("enter your new text: ");
                            commentTxt = scanner.nextLine();
                            comment.setComment(commentTxt);
                            commentService.update(comment);
                            break;
                        case 12:
                            System.out.println("enter comment id: ");
                            commentService.deleteById(scanner.nextLong());
                            break;
                        case 13:
                            System.out.println("enter twit id: ");
                            twit = twitService.findById(scanner.nextLong());
                            Long likes = twit.getLikes();
                            likes += 1;
                            twit.setLikes(likes);
                            twitService.update(twit);
                            break;
                        case 14:
                            System.out.println("enter twit id: ");
                            twit = twitService.findById(scanner.nextLong());
                            Long numberOfDisLikes = twit.getDisLike();
                            numberOfDisLikes += 1;
                            twit.setDisLike(numberOfDisLikes);
                            twitService.update(twit);
                            break;
                        case 15:
                            System.out.println("enter your acc id: ");
                            account = accountService.findById(scanner.nextLong());
                            System.out.println("you are following: " + account.getFollowing().size() +
                                    " account: ");
                            account.getFollowing().stream().map(Account::getUserName)
                                    .forEach(System.out::println);

//                            for (Account a : account.getFollowing()) {
//                                a.setPassword("******");
//                                System.out.println(a);
//                            }
                            break;
                        case 16:
                            scanner.nextLine();
                            System.out.println("enter username : ");
                            account = accountService.findByUsername(scanner.nextLine());
                            System.out.println(account);
                            break;
                        case 17:
                            System.out.println("enter your acc id: ");
                            account = accountService.findById(scanner.nextLong());
                            System.out.println("enter id of acc you want follow: ");
                            account2 = accountService.findById(scanner.nextLong());
                            account.getFollowing().add(account2);
                            accountService.update(account);
                            account2.getFollowers().add(account);
                            accountService.update(account2);
                            break;
                        case 18:
                            System.out.println("enter your acc id: ");
                            account = accountService.findById(scanner.nextLong());
                            System.out.println("you are have "+account.getFollowers().size()+" followers: ");
                            account.getFollowers()
                                    .stream()
                                    .map(Account::getUserName)
                                    .forEach(System.out::println);
                            break;
                        case 19:
                            System.out.println("enter your acc id: ");
                            account = accountService.findById(scanner.nextLong());
                            System.out.println("enter id of acc you want UnFollow: ");
                            account2 = accountService.findById(scanner.nextLong());
                            account.getFollowing().remove(account2);
                            accountService.update(account);
                            account2.getFollowers().remove(account);
                            accountService.update(account2);
                            break;
                        case 20:
                            System.out.println("enter your acc id: ");
                            account = accountService.findById(scanner.nextLong());
                            System.out.println("enter comment id: ");
                            comment = commentService.findById(scanner.nextLong());
                            scanner.nextLine();
                            System.out.println("Enter replay text: ");
                            replayTxt = scanner.nextLine();
                            replay = new Replay(null, replayTxt, comment, account);
                            replayService.save(replay);
                            break;
                        case 21:
                            System.out.println("enter comment id: ");
                            comment = commentService.findById(scanner.nextLong());
                            replayService.findAll(comment.getId()).forEach(System.out::println);
                            break;
                        case 22:
                            loop = false;
                            break;

                    }
                }
            }

        } else if (role == 2) {
            scanner.nextLine();
            System.out.println("enter your username: ");
            userName = scanner.nextLine();
            System.out.println("enter your password: ");
            password = scanner.nextLine();
            System.out.println("enter your fullName: ");
            fullName = scanner.nextLine();
            followers = new HashSet<>();
            following = new HashSet<>();
            account = new Account(null, userName, password, fullName, followers, following);
            accountService.save(account);
            System.out.println("done! ");
        } else System.out.println("wrong number");


    }
}
