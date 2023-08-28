package com.fssa.freshnest.model;

public class Invite {

    private User user;
    private String inviteType;
    private String inviteDate;
    private String inviteTime;
    private String specialPerson;
    private String inviteSlogan;
    private String inviteExplanation;
    private int inviteId;
    private int reactorId;
    private boolean isLike;
    private boolean isAccept;
    private boolean isDislike;
    private String inviteMessage;
    // Constructor

    // Default Constructor
    public Invite() {

    }

    // Invite create constructor
    public Invite(User user, String inviteType, String inviteDate, String inviteTime, String specialPerson,
                  String inviteSlogan, String inviteExplanation) {
        this.user = user;
        this.inviteType = inviteType;
        this.inviteDate = inviteDate;
        this.inviteTime = inviteTime;
        this.specialPerson = specialPerson;
        this.inviteSlogan = inviteSlogan;
        this.inviteExplanation = inviteExplanation;
    }

    // Invite update constructor
    public Invite(String inviteType, String inviteDate, String inviteTime, String specialPerson, String inviteSlogan,
                  String inviteExplanation, int inviteId) {
        this.inviteType = inviteType;
        this.inviteDate = inviteDate;
        this.inviteTime = inviteTime;
        this.specialPerson = specialPerson;
        this.inviteSlogan = inviteSlogan;
        this.inviteExplanation = inviteExplanation;
        this.inviteId = inviteId;
    }

    // invite delete constructor

    public Invite(int inviteId) {
        this.inviteId = inviteId;
    }
    // Getters and letters

    public Invite(int inviteId, int reactorId, boolean isAccept, boolean isLike, boolean isDislike, String message) {
        this.inviteId = inviteId;
        this.reactorId = reactorId;
        this.isAccept = isAccept;
        this.isLike = isLike;
        this.isDislike = isDislike;
        this.inviteMessage = message;
    }

    public boolean getIsLike() {
        return isLike;
    }

    public void setIsLike(boolean isLike) {
        this.isLike = isLike;
    }

    public boolean getIsAccept() {
        return isAccept;
    }

    public void setIsAccept(boolean isAccept) {
        this.isAccept = isAccept;
    }

    public boolean getIsDislike() {
        return isDislike;
    }

    public void setIsDislike(boolean isDislike) {
        this.isDislike = isDislike;
    }

    public String getInviteMessage() {
        return inviteMessage;
    }

    public void setInviteMessage(String inviteMessage) {
        this.inviteMessage = inviteMessage;
    }

    public int getReactorId() {
        return reactorId;
    }

    public void setReactorId(int reactorId) {
        this.reactorId = reactorId;
    }

    public int getInviteId() {
        return inviteId;
    }

    public void setInviteId(int inviteId) {
        this.inviteId = inviteId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getInviteType() {
        return inviteType;
    }

    public void setInviteType(String inviteType) {
        this.inviteType = inviteType;
    }

    public String getInviteDate() {
        return inviteDate;
    }

    public void setInviteDate(String inviteDate) {
        this.inviteDate = inviteDate;
    }

    public String getInviteTime() {
        return inviteTime;
    }

    public void setInviteTime(String inviteTime) {
        this.inviteTime = inviteTime;
    }

    public String getSpecialPerson() {
        return specialPerson;
    }

    public void setSpecialPerson(String specialPerson) {
        this.specialPerson = specialPerson;
    }

    public String getInviteSlogan() {
        return inviteSlogan;
    }

    public void setInviteSlogan(String inviteSlogan) {
        this.inviteSlogan = inviteSlogan;
    }

    public String getInviteExplanation() {
        return inviteExplanation;
    }

    public void setInviteExplanation(String inviteExplanation) {
        this.inviteExplanation = inviteExplanation;
    }

    @Override
    public String toString() {
        return "Invite{" +
                "userId=" + user +
                ", inviteType='" + inviteType + '\'' +
                ", inviteDate='" + inviteDate + '\'' +
                ", inviteTime='" + inviteTime + '\'' +
                ", specialPerson='" + specialPerson + '\'' +
                ", inviteSlogan='" + inviteSlogan + '\'' +
                ", inviteExplanation='" + inviteExplanation + '\'' +
                ", inviteId=" + inviteId +
                ", reactorId=" + reactorId +
                ", isLike=" + isLike +
                ", isAccept=" + isAccept +
                ", isDislike=" + isDislike +
                ", inviteMessage='" + inviteMessage + '\'' +
                '}';
    }
}
