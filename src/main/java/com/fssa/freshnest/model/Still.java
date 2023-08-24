package com.fssa.freshnest.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Still {
    private String stillUrl;
    private int userId;
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

    public Still(String stillUrl, int userId, String stillName, LocalDate stillDate, LocalTime stillTime,
                 boolean isFavourite, boolean isDelete) {
        this.stillUrl = stillUrl;
        this.userId = userId;
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

    public Still(int stillId, boolean isUpdate) {
        this.stillId = stillId;
        this.isUpdate = isUpdate;
    }

    public Still(boolean isDelete, int stillId, int userId) {
        this.isDelete = isDelete;
        this.stillId = stillId;
        this.userId = userId;

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
        return "Still{" + "stillUrl='" + stillUrl + '\'' + ", userId=" + userId + ", stillName='" + stillName + '\''
                + ", stillDate=" + stillDate + ", stillTime=" + stillTime + ", isFavourite=" + isFavourite
                + ", isDelete=" + isDelete + ", stillId=" + stillId + ", isUpdate=" + isUpdate + '}';
    }
}
