package com.test.Models;

import javax.persistence.*;
import java.util.Arrays;

/**
 * Created by Aaron on 1/29/2018.
 */
@Entity
@Table(name = "Post_Comments", schema = "dreamloudPROD", catalog = "")
public class PostCommentsEntity {
    private int commentId;
    private byte[] commentContent;
    private byte[] pictureComment;
    private Integer acctId;
    private Integer postId;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getAcctId() {
        return acctId;
    }

    public void setAcctId(Integer acctId) {
        this.acctId = acctId;
    }

    @Id
    @Column(name = "commentId", nullable = false)
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    @Basic
    @Column(name = "comment_content", nullable = true)
    public byte[] getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(byte[] commentContent) {
        this.commentContent = commentContent;
    }

    @Basic
    @Column(name = "picture_comment", nullable = true)
    public byte[] getPictureComment() {
        return pictureComment;
    }

    public void setPictureComment(byte[] pictureComment) {
        this.pictureComment = pictureComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostCommentsEntity that = (PostCommentsEntity) o;

        if (commentId != that.commentId) return false;
        if (!Arrays.equals(commentContent, that.commentContent)) return false;
        if (!Arrays.equals(pictureComment, that.pictureComment)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commentId;
        result = 31 * result + Arrays.hashCode(commentContent);
        result = 31 * result + Arrays.hashCode(pictureComment);
        return result;
    }
}
