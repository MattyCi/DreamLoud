package com.test.Helpers;

import com.test.DAOs.DreamLoudDao;
import com.test.Models.DreamPostsEntity;
import com.test.Models.TranslatedPosts;

import java.util.ArrayList;

public class NewsfeedHelper {
    private DreamLoudDao dao;
    public NewsfeedHelper(DreamLoudDao dao) {
        this.dao = dao;
    }

    public ArrayList<TranslatedPosts> getRelatedDreamPosts(String userId){
        ArrayList<DreamPostsEntity> posts = dao.getDreamPosts(userId);
        return translatePosts(posts);
    }

    private ArrayList<TranslatedPosts> translatePosts(ArrayList<DreamPostsEntity> posts) {
        ArrayList<TranslatedPosts> translatedPosts = new ArrayList<TranslatedPosts>();
        for (DreamPostsEntity post: posts) {
            TranslatedPosts translatedPost = new TranslatedPosts();
            translatedPost.setContent(new String(post.getPostContent()));
            translatedPost.setPostTitle(post.getPostTitle());
            translatedPosts.add(translatedPost);
        }
        return translatedPosts;
    }

}
