package com.test.Models;

import java.util.ArrayList;

public class TranslatedPosts {

    String userName;

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

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    String postTitle;
    String DreamName;
    String content;
    ArrayList<String> comments;

}
