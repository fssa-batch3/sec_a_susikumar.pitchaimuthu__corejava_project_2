package com.fssa.freshnest.model;

public class InviteReaction {
	private int userId;
	private int inviteId;
	private boolean isSendRequest;
	private boolean isLike;
	private boolean isReject;
	private String inviteMessage;
	private int reactId;

	public int getReactId() {
		return reactId;
	}

	public void setReactId(int reactId) {
		this.reactId = reactId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getInviteId() {
		return inviteId;
	}

	public void setInviteId(int inviteId) {
		this.inviteId = inviteId;
	}

	public boolean isSendRequest() {
		return isSendRequest;
	}

	public void setSendRequest(boolean isSendRequest) {
		this.isSendRequest = isSendRequest;
	}

	public boolean isLike() {
		return isLike;
	}

	public void setLike(boolean isLike) {
		this.isLike = isLike;
	}

	public boolean isReject() {
		return isReject;
	}

	public void setReject(boolean isReject) {
		this.isReject = isReject;
	}

	public String getInviteMessage() {
		return inviteMessage;
	}

	public void setInviteMessage(String inviteMessage) {
		this.inviteMessage = inviteMessage;
	}

	@Override
	public String toString() {
		return "InviteReaction [userId=" + userId + ", inviteId=" + inviteId + ", isSendRequest=" + isSendRequest
				+ ", isLike=" + isLike + ", isReject=" + isReject + ", inviteMessage=" + inviteMessage + "]";
	}
}
