package com.test.Models;

import java.util.ArrayList;

public class TranslatedPosts {

    String userName;
    String postTitle;
    String DreamName;
    String DreamId;
    String content;
    ArrayList<PostComments> comments;
    String postId;
    String userPic;
    String postDate;

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
