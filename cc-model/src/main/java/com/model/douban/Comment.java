package com.model.douban;

/**
 * Created by IntelliJ IDEA.
 * User: yahui
 * Date: 2019/5/29
 * To change this template use File | Settings | File Templates.
 **/
public class Comment {
    private String doubanCommentId;
    private String userId;
    private double rate;
    private String date;
    private String comment;
    private int agree;
    private String bookId;
    private String createdDate;
    private String modifiedDate;
    private String state;
    private String commentId;

    public Comment(){}
    public Comment(String doubanCommentId, String userId, double rate, String date, String comment, int agree, String bookId, String createdDate, String modifiedDate, String state, String commentId) {
        this.doubanCommentId = doubanCommentId;
        this.userId = userId;
        this.rate = rate;
        this.date = date;
        this.comment = comment;
        this.agree = agree;
        this.bookId = bookId;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.state = state;
        this.commentId = commentId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "doubanCommentId='" + doubanCommentId + '\'' +
                ", userId='" + userId + '\'' +
                ", rate=" + rate +
                ", date='" + date + '\'' +
                ", comment='" + comment + '\'' +
                ", agree=" + agree +
                ", bookId='" + bookId + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", modifiedDate='" + modifiedDate + '\'' +
                ", state='" + state + '\'' +
                ", commentId='" + commentId + '\'' +
                '}';
    }

    public String getDoubanCommentId() {
        return doubanCommentId;
    }

    public void setDoubanCommentId(String doubanCommentId) {
        this.doubanCommentId = doubanCommentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getAgree() {
        return agree;
    }

    public void setAgree(int agree) {
        this.agree = agree;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }
}
