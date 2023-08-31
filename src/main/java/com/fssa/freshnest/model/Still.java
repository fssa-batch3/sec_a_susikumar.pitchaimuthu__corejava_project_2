package com.fssa.freshnest.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Still {
    private String stillUrl;
    private User user;
    private String stillName;
    private LocalDate stillDate;
    private LocalTime stillTime;
    private boolean isFavourite;
    private boolean isDelete;
    private int stillId;
    private boolean isUpdate;

    // Constructor

    // Default Constructor
    public Still() {

    }

    public Still(String stillUrl, User user, String stillName, LocalDate stillDate, LocalTime stillTime,
                 boolean isFavourite, boolean isDelete) {
        this.stillUrl = stillUrl;
        this.user = user;
        this.stillName = stillName;
        this.stillDate = stillDate;
        this.stillTime = stillTime;
        this.isFavourite = isFavourite;
        this.isDelete = isDelete;
    }

    public Still(boolean isFavourite, int stillId) {
        this.isFavourite = isFavourite;
        this.stillId = stillId;
    }


    public Still(boolean isDelete, int stillId, User user) {
        this.isDelete = isDelete;
        this.stillId = stillId;
        this.user = user;

    }

    public Still(User user) {
        this.user = user;
    }

    public Still(int stillId) {
        this.stillId = stillId;
    }

    public int getStillId() {
        return stillId;
    }

    public void setStillId(int stillId) {
        this.stillId = stillId;
    }

    public String getStillUrl() {
        return stillUrl;
    }

    public void setStillUrl(String stillUrl) {
        this.stillUrl = stillUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean getIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(boolean isUpdate) {
        this.isUpdate = isUpdate;
    }

    public String getStillName() {
        return stillName;
    }

    public void setStillName(String stillName) {
        this.stillName = stillName;
    }

    public LocalDate getStillDate() {
        return stillDate;
    }

    public void setStillDate(LocalDate stillDate) {
        this.stillDate = stillDate;
    }

    public LocalTime getStillTime() {
        return stillTime;
    }

    public void setStillTime(LocalTime stillTime) {
        this.stillTime = stillTime;
    }

    public boolean getIsFavourite() {
        return isFavourite;
    }

    public void setIsFavourite(boolean isFavourite) {
        this.isFavourite = isFavourite;
    }

    public boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Still{" + "stillUrl='" + stillUrl + '\'' + ", userId=" + user + ", stillName='" + stillName + '\''
                + ", stillDate=" + stillDate + ", stillTime=" + stillTime + ", isFavourite=" + isFavourite
                + ", isDelete=" + isDelete + ", stillId=" + stillId + ", isUpdate=" + isUpdate + '}';
    }
}
