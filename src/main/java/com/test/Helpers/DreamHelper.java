package com.test.Helpers;

import com.test.DAOs.DreamLoudDao;
import com.test.Models.DreamPostsEntity;
import com.test.Models.DreamsEntity;
import com.test.Models.TranslatedPosts;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Created by Aaron on 2/10/2018.
 */
public class DreamHelper {

    private DreamLoudDao dao;
    private NewsfeedHelper newsfeedHelper;
    public DreamHelper(DreamLoudDao dao) {
        this.dao = dao;
        newsfeedHelper = new NewsfeedHelper(dao);
    }

    public ArrayList<TranslatedPosts> getRelatedDreamPosts(String dreamId, String userId) {
        ArrayList<DreamPostsEntity> posts = dao.getDreamPostsByDreamId(Integer.parseInt(dreamId));
        return newsfeedHelper.translatePosts(posts, userId);
    }

    public DreamsEntity getDream(String dreamId) {
        return dao.getDreamById(Integer.parseInt(dreamId));
    }

    public void createPost(String postContent, String dreamId, String userId) {
        DreamPostsEntity dreamPostsEntity = new DreamPostsEntity();
        dreamPostsEntity.setAcctId(Integer.parseInt(userId));
        dreamPostsEntity.setDreamId(Integer.parseInt(dreamId));
        dreamPostsEntity.setDatePosted(new Timestamp(System.currentTimeMillis()));
        dreamPostsEntity.setPostContent(postContent.getBytes());
        dao.createPost(dreamPostsEntity);
    }
}
