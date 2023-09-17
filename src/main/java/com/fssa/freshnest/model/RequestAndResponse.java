package com.fssa.freshnest.model;

import java.sql.Timestamp;

public class RequestAndResponse {

    private int requestSenderId;
    private int requestReceiverId;
    private String requestType;
    private String requestText;
    private Timestamp notifyAt;
    private int notificationId;
    private String profileImage;
    private int userId;
    private String username;
    private String userTheme;


    // Follow connection getters and setters
    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserTheme() {
        return userTheme;
    }

    public void setUserTheme(String userTheme) {
        this.userTheme = userTheme;
    }


    public Timestamp getNotifyAt() {
        return notifyAt;
    }

    public void setNotifyAt(Timestamp notifyAt) {
        this.notifyAt = notifyAt;
    }


    public int getRequestSenderId() {
        return requestSenderId;
    }

    public void setRequestSenderId(int requestSenderId) {
        this.requestSenderId = requestSenderId;
    }

    public int getRequestReceiverId() {
        return requestReceiverId;
    }

    public void setRequestReceiverId(int requestReceiverId) {
        this.requestReceiverId = requestReceiverId;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getRequestText() {
        return requestText;
    }

    public void setRequestText(String requestText) {
        this.requestText = requestText;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    @Override
    public String toString() {
        return "RequestAndResponse{" +
                "requestSenderId=" + requestSenderId +
                ", requestReceiverId=" + requestReceiverId +
                ", requestType='" + requestType + '\'' +
                ", requestText='" + requestText + '\'' +
                ", notifyAt=" + notifyAt +
                ", notificationId=" + notificationId +
                ", profileImage='" + profileImage + '\'' +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", userTheme='" + userTheme + '\'' +
                '}';
    }
}
