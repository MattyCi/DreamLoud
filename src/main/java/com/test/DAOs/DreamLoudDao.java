package com.test.DAOs;

import com.test.Models.*;

import java.util.ArrayList;

/**
 * Created by Aaron on 11/28/2017.
 */
public interface DreamLoudDao {

    AccountEntity getAccountById(String acctId);

    ArrayList<AccountEntity> getAccountsInDream(String dreamId);
    ArrayList<DreamersEntity> getDreamers(Integer userId);

    void addAccount(AccountEntity accountEntity);


    void updateAccount(AccountEntity accountEntity);


    void deleteAccount(AccountEntity acct);

    void deleteDream(DreamsEntity dream);

    void deleteDreamChat(String dreamChatId);

    void deleteDreamer(String acctId);

    AccountEntity getAccountByEmailAndPassword(String email, String password);

    ArrayList<DreamPostsEntity> getDreamPosts(String userId);

    ArrayList<PostCommentsEntity> getPostComments(int postId);

    void postComment(PostCommentsEntity comment);

    DreamsEntity getDreamById(Integer dreamId);

    void followDream(DreammemsEntity dreammemsEntity) throws Exception;

    DreammemsEntity getDremMemByUserIdAndDrmId(int acctId, int drmId);

    void unfollowDream(DreammemsEntity dreammemsEntity) throws Exception;

    ArrayList<DreammemsEntity> getDremMemByDrmId(int drmId);

    ArrayList<DreamPostsEntity> getDreamPostsByDreamId(int drmId);

    void createPost(DreamPostsEntity dreamPostsEntity);

    void addDream(DreamsEntity dreamsEntity);

    AccountEntity getAccountByEmail(String userEmail);

    DreamsEntity getDreamByName(String dreamName);

    ArrayList<AccountEntity> getAccountsByIds(ArrayList<Integer> dreamerIds);

    void addDreamers(DreamersEntity dreamersEntity);

    DreamersEntity getDreamer(String userId, String dreamerId);

    void removeDreamer(DreamersEntity dreamer);

    ArrayList<DreamPostsEntity> getRecentPosts(String dreamerId);

    ArrayList<PostCommentsEntity> getRecentComments(String dreamerId);

    DreamPostsEntity getDreamPostByPostId(String postId);
}
