package com.test.Models;

import java.util.ArrayList;

public class TranslatedPosts {

    private String userName;
    private String postTitle;
    private String DreamName;
    private String DreamId;
    private String content;
    private ArrayList<PostComments> comments;
    private String postId;
    private String userPic;
    private String postDate;
    private String numberOfFollowers;
    private boolean isFollowingDream;

    public String getNumberOfFollowers() {
        return numberOfFollowers;
    }

    public void setNumberOfFollowers(String numberOfFollowers) {
        this.numberOfFollowers = numberOfFollowers;
    }

    public boolean isFollowingDream() {
        return isFollowingDream;
    }

    public void setFollowingDream(boolean followingDream) {
        isFollowingDream = followingDream;
    }

    public String getDreamId() {
        return DreamId;
    }

    public void setDreamId(String dreamId) {
        DreamId = dreamId;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getDreamName() {
        return DreamName;
    }

    public void setDreamName(String dreamName) {
        DreamName = dreamName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<PostComments> getComments() {
        return comments;
    }

    public void setComments(ArrayList<PostComments> comments) {
        this.comments = comments;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }


}
