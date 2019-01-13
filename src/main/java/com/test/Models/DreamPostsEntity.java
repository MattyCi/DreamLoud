package com.test.Models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;

@Entity
@Table(name = "dream_posts", schema = "dreamloudPROD", catalog = "")
public class DreamPostsEntity {
    private int dreamPostId;
    private String postTitle;
    private byte[] postContent;
    private byte[] postPic;
    private Integer acctId;
    private Integer dreamId;
    private Timestamp datePosted;

    @Basic
    @Column(name = "TIME_POSTED", nullable = false)
    public Timestamp getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Timestamp datePosted) {
        this.datePosted = datePosted;
    }

    @Basic
    @Column(name = "DRM_ID", nullable = false)
    public Integer getDreamId() {
        return dreamId;
    }

    public void setDreamId(Integer dreamId) {
        this.dreamId = dreamId;
    }

    @Basic
    @Column(name = "ACCT_ID", nullable = false)
    public Integer getAcctId() {
        return acctId;
    }

    public void setAcctId(Integer acctId) {
        this.acctId = acctId;
    }

    @Id
    @Column(name = "DREAM_POST_ID", nullable = false)
    public int getDreamPostId() {
        return dreamPostId;
    }

    public void setDreamPostId(int dreamPostId) {
        this.dreamPostId = dreamPostId;
    }

    @Basic
    @Column(name = "POST_TITLE", nullable = true, length = 255)
    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    @Basic
    @Column(name = "POST_CONTENT", nullable = true)
    public byte[] getPostContent() {
        return postContent;
    }

    public void setPostContent(byte[] postContent) {
        this.postContent = postContent;
    }

    @Basic
    @Column(name = "POST_PIC", nullable = true)
    public byte[] getPostPic() {
        return postPic;
    }

    public void setPostPic(byte[] postPic) {
        this.postPic = postPic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DreamPostsEntity that = (DreamPostsEntity) o;

        if (dreamPostId != that.dreamPostId) return false;
        if (postTitle != null ? !postTitle.equals(that.postTitle) : that.postTitle != null) return false;
        if (!Arrays.equals(postContent, that.postContent)) return false;
        if (!Arrays.equals(postPic, that.postPic)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dreamPostId;
        result = 31 * result + (postTitle != null ? postTitle.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(postContent);
        result = 31 * result + Arrays.hashCode(postPic);
        return result;
    }
}
