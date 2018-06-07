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
            translatedPosts.add(translatePost(post, userId));
        }
        return translatedPosts;
    }

    private TranslatedPosts translatePost(DreamPostsEntity dreamPostsEntity, String userId){
        TranslatedPosts translatedPost = new TranslatedPosts();
        AccountEntity acct = dao.getAccountById(String.valueOf(dreamPostsEntity.getAcctId()));
        ArrayList<PostComments> comments = getRelatedComments(dreamPostsEntity.getDreamPostId());
        DreamsEntity dream = dao.getDreamById(dreamPostsEntity.getDreamId());
        translatedPost.setComments(comments);
        translatedPost.setUserName(acct.getAcctFname() + " " + acct.getAcctLname());
        translatedPost.setUserPic(acct.getAcctPic());
        translatedPost.setContent(new String(dreamPostsEntity.getPostContent()));
        translatedPost.setPostTitle(dreamPostsEntity.getPostTitle());
        translatedPost.setPostId(String.valueOf(dreamPostsEntity.getDreamPostId()));
        translatedPost.setDreamName(dream.getDrmName());
        translatedPost.setDreamId(String.valueOf(dream.getDrmId()));
        translatedPost.setFollowingDream(isFollowingDream(userId, String.valueOf(dream.getDrmId())));
        translatedPost.setPostDate(getPostDateFormatted(dreamPostsEntity));
        translatedPost.setNumberOfFollowers(getNumOfFollwers(dream));
        translatedPost.setAcctId(String.valueOf(dreamPostsEntity.getAcctId()));
        return translatedPost;
    }

    private ArrayList<PostComments> getRelatedComments(int postId){
        ArrayList<PostCommentsEntity> commentsEntities = dao.getPostComments(postId);
        return translateComments(commentsEntities);
    }

    private ArrayList<PostComments> translateComments(ArrayList<PostCommentsEntity> postCommentsEntities){
        ArrayList<PostComments> comments =new ArrayList<PostComments>();
        for (PostCommentsEntity commentEntity:postCommentsEntities) {
            PostComments comment = new PostComments();
            AccountEntity commentAcct = dao.getAccountById(commentEntity.getAcctId().toString());
            comment.setContent(new String(commentEntity.getCommentContent()));
            comment.setUsername(commentAcct.getAcctFname() +" "+ commentAcct.getAcctLname());
            comment.setAcctPictureUrl(commentAcct.getAcctPic());
            comment.setAcctId(String.valueOf(commentAcct.getAcctId()));
            comment.setPostId(commentEntity.getPostId().toString());
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

    public ArrayList<RecentActivity> getRecentActivity(String dreamerId){
        ArrayList<DreamPostsEntity> dreamPostsEntities = dao.getRecentPosts(dreamerId);
        ArrayList<PostCommentsEntity> postCommentsEntities = dao.getRecentComments(dreamerId);

        return translateRecentActivity(dreamPostsEntities, postCommentsEntities, dreamerId);
    }

    private ArrayList<RecentActivity> translateRecentActivity(ArrayList<DreamPostsEntity> dreamPostsEntities, ArrayList<PostCommentsEntity> postCommentsEntities, String dreamerId){

        ArrayList<RecentActivity> recentActivities = new ArrayList<RecentActivity>();
        ArrayList<TranslatedPosts> translatedPosts = translatePosts(dreamPostsEntities, dreamerId);
        ArrayList<PostComments> postComments = translateComments(postCommentsEntities);

        for (TranslatedPosts translatedPost: translatedPosts) {
            RecentActivity recentActivity = new RecentActivity();
            recentActivity.setDate(translatedPost.getPostDate());
            recentActivity.setActivity("Post");
            recentActivity.setDreamName(translatedPost.getDreamName());
            recentActivities.add(recentActivity);
        }

        assert postComments != null;
        for (PostComments postComment:postComments) {
            TranslatedPosts translatedPost = translatePost(dao.getDreamPostByPostId(postComment.getPostId()), dreamerId);
            RecentActivity recentActivity = new RecentActivity();
            recentActivity.setDate(postComment.getDate());
            recentActivity.setActivity("Comment");
            recentActivity.setDreamName(translatedPost.getDreamName());
            recentActivities.add(recentActivity);
        }
        return recentActivities;
    }

}
