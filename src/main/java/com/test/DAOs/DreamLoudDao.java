package com.test.DAOs;

import com.test.Models.*;

import java.util.ArrayList;

/**
 * Created by Aaron on 11/28/2017.
 */
public interface DreamLoudDao {

    AccountEntity getAccountById(String acctId);

    ArrayList<AccountEntity> getAccountsInDream(String dreamId);


    void addAccount(AccountEntity accountEntity);


    void updateAccount(AccountEntity accountEntity);


    void deleteAccount(String acctId);

    void deleteDream(String dreamId);

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
}
