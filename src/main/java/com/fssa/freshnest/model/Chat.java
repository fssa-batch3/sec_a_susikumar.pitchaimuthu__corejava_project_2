package com.fssa.freshnest.model;

public class Chat {

	private String chatType;
	private int chatName;
	private int chatId;
	private int userId;
	private int senderId;
	private String chatMessage;
	private boolean isDelete;
	private boolean isUpdate;

	// chat id and user id constructor
	public Chat(int chatId, int userId) {
		this.chatId = chatId;
		this.userId = userId;
	}

	// chat and sender id setting constructor
	public Chat(int chatId, int senderId, String chatMessage) {
		this.chatId = chatId;
		this.senderId = senderId;
		this.chatMessage = chatMessage;
	}
	// chat data type insert constructor
	public Chat(String chatType, int chatName) {
		this.chatType = chatType;
		this.chatName = chatName;
	}

	// chat read constructor
	public Chat(int chatId) {
		this.chatId = chatId;
	}

	// Delete chat constructor
	public Chat(boolean isDelete, int chatId) {
		this.isDelete = isDelete;
		this.chatId = chatId;
	}

	public String getChatType() {
		return chatType;
	}

	public void setChatType(String chatType) {
		this.chatType = chatType;
	}

	public boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public boolean getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(boolean is_update) {
		this.isUpdate = is_update;
	}

	public Chat() {

	}

	public int getChatName() {
		return chatName;
	}

	public void setChatName(int chatName) {
		this.chatName = chatName;
	}

	public int getChatId() {
		return chatId;
	}

	public void setChatId(int chatId) {
		this.chatId = chatId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public String getChat_message() {
		return chatMessage;
	}

	public void setChat_message(String chatMessage) {
		this.chatMessage = chatMessage;
	}

}
