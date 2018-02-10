package com.test.Helpers;

import com.test.DAOs.DreamLoudDao;
import com.test.Models.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class NewsfeedHelper {
    private DreamLoudDao dao;
    public NewsfeedHelper(DreamLoudDao dao) {
        this.dao = dao;
    }

    public ArrayList<TranslatedPosts> getRelatedDreamPosts(String userId){
        ArrayList<DreamPostsEntity> posts = dao.getDreamPosts(userId);
        return translatePosts(posts, userId);
    }

    public ArrayList<TranslatedPosts> translatePosts(ArrayList<DreamPostsEntity> posts, String userId) {
        ArrayList<TranslatedPosts> translatedPosts = new ArrayList<TranslatedPosts>();
        for (DreamPostsEntity post: posts) {
            TranslatedPosts translatedPost = new TranslatedPosts();
            AccountEntity acct = dao.getAccountById(String.valueOf(post.getAcctId()));
            ArrayList<PostComments> comments = getRelatedComments(post.getDreamPostId());
            DreamsEntity dream = dao.getDreamById(post.getDreamId());
            translatedPost.setComments(comments);
            translatedPost.setUserName(acct.getAcctFname() + " " + acct.getAcctLname());
            translatedPost.setUserPic(acct.getAcctPic());
            translatedPost.setContent(new String(post.getPostContent()));
            translatedPost.setPostTitle(post.getPostTitle());
            translatedPost.setPostId(String.valueOf(post.getDreamPostId()));
            translatedPost.setDreamName(dream.getDrmName());
            translatedPost.setDreamId(String.valueOf(dream.getDrmId()));
            translatedPost.setFollowingDream(isFollowingDream(userId, String.valueOf(dream.getDrmId())));
            translatedPost.setPostDate(getPostDateFormatted(post));
            translatedPost.setNumberOfFollowers(getNumOfFollwers(dream));
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

    public void postComment(PostCommentsEntity comment) {
        dao.postComment(comment);
    }

    public boolean followDream(String userId, String dreamId) {
        DreammemsEntity dreammemsEntity = new DreammemsEntity();
        dreammemsEntity.setAcctId(Integer.parseInt(userId));
        dreammemsEntity.setDrmId(Integer.parseInt(dreamId));
        DreammemsEntity dreamCheck = dao.getDremMemByUserIdAndDrmId(Integer.parseInt(userId), Integer.parseInt(dreamId));
        if(dreamCheck == null) {
            try {
                dao.followDream(dreammemsEntity);
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean unfollowDream(String userId, String dreamId) {
        DreammemsEntity dreammemsEntity = dao.getDremMemByUserIdAndDrmId(Integer.parseInt(userId), Integer.parseInt(dreamId));
        try {
            dao.unfollowDream(dreammemsEntity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private String getPostDateFormatted(DreamPostsEntity dreamPostsEntity){
        Timestamp timeStamp = dreamPostsEntity.getDatePosted();
        SimpleDateFormat format = new SimpleDateFormat("EEE, MMM d 'at' h:mm aaa");
        return format.format(timeStamp);
    }

    private boolean isFollowingDream(String userId, String dreamId){
        DreammemsEntity dreammemsEntity = dao.getDremMemByUserIdAndDrmId(Integer.parseInt(userId), Integer.parseInt(dreamId));
        return dreammemsEntity != null;
    }

    private String getNumOfFollwers(DreamsEntity dreamsEntity){
        ArrayList<DreammemsEntity> dreammemsEntities = dao.getDremMemByDrmId(dreamsEntity.getDrmId());
        return String.valueOf(dreammemsEntities.size());
    }

}
