package com.test.Helpers;

import com.test.DAOs.DreamLoudDao;
import com.test.Models.*;
import javafx.geometry.Pos;
import org.hibernate.boot.jaxb.SourceType;

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
            ArrayList<PostComments> comments = getRelatedComments(post.getDreamPostId());
            translatedPost.setComments(comments);
            translatedPost.setContent(new String(post.getPostContent()));
            translatedPost.setPostTitle(post.getPostTitle());
            translatedPost.setPostId(String.valueOf(post.getDreamPostId()));
            translatedPosts.add(translatedPost);
        }
        return translatedPosts;
    }

    private ArrayList<PostComments> getRelatedComments(int postId){
        ArrayList<PostComments> comments =new ArrayList<PostComments>();
        ArrayList<PostCommentsEntity> commentsEntities = dao.getPostComments(postId);
        for (PostCommentsEntity commentEntity:commentsEntities) {
            PostComments comment = new PostComments();
            AccountEntity commentAcct = dao.getAccountById(commentEntity.getAcctId().toString());
            comment.setContent(new String(commentEntity.getCommentContent()));
            comment.setUsername(commentAcct.getAcctFname() +" "+ commentAcct.getAcctLname());
            comment.setAcctPictureUrl(commentAcct.getAcctPic());
            comments.add(comment);
        }
        return comments;
    }

}
