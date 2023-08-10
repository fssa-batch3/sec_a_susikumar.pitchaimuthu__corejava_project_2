package com.fssa.freshnest.model;

public class Invite {

    private int userId;
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

    // Invite create constructor
    public Invite(int userId, String inviteType, String inviteDate, String inviteTime, String specialPerson,
                  String inviteSlogan, String inviteExplanation) {
        this.userId = userId;
        this.inviteType = inviteType;
        this.inviteDate = inviteDate;
        this.inviteTime = inviteTime;
        this.specialPerson = specialPerson;
        this.inviteSlogan = inviteSlogan;
        this.inviteExplanation = inviteExplanation;
    }

    // Invite update constructor
    public Invite(int userId, String inviteType, String inviteDate, String inviteTime, String specialPerson,
                  String inviteSlogan, String inviteExplanation, int inviteId) {
        this.userId = userId;
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

    public void setInvite_id(int inviteId) {
        this.inviteId = inviteId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUser_id(int userId) {
        this.userId = userId;
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

}
