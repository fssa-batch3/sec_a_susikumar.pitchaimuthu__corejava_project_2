package com.fssa.freshnest.model;

import java.sql.Timestamp;

public class TimeTales {
	private User user;
    private int taleId;
    private int userId;
    private String mediaUrl;
    private String profileImage;
    private String username;
    private Timestamp expireAt;
    private Double taleDuration;
    private Timestamp createdAt;
    

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }


    public Double getTaleDuration() {
        return taleDuration;
    }

    public void setTaleDuration(Double taleDuration) {
        this.taleDuration = taleDuration;
    }


    public Timestamp getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(Timestamp expireAt) {
        this.expireAt = expireAt;
    }


    public int getTaleId() {
        return taleId;
    }

    public void setTaleId(int taleId) {
        this.taleId = taleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "TimeTales{" +
                "taleId=" + taleId +
                ", userId=" + userId +
                ", media_url='" + mediaUrl + '\'' +
                ", profileImage='" + profileImage + '\'' +
                ", username='" + username + '\'' +
                ", expireAt=" + expireAt +
                ", taleDuration=" + taleDuration +
                ", createdAt=" + createdAt +
                '}';
    }
}
