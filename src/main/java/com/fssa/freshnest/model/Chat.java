package com.fssa.freshnest.model;

public class Chat {

    private String chatType;
    private int chatName;
    private int chatId;
    private int userId;
    private int senderId;
    private int messageId;
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
    public Chat(boolean isDelete, int chatId, int messageId) {
        this.isDelete = isDelete;
        this.chatId = chatId;
        this.messageId = messageId;
    }
    
    public Chat(String chatText, int chatId, int messageId) {
	    this.chatMessage = chatText;
	    this.chatId = chatId;
	    this.messageId = messageId;
	}

	// getters and setters
	public String getChatType() {
		return chatType;
	}

	public void setChatType(String chatType) {
		this.chatType = chatType;
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

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getChatMessage() {
		return chatMessage;
	}

	public void setChatMessage(String chatMessage) {
		this.chatMessage = chatMessage;
	}

	public boolean getDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public boolean getUpdate() {
		return isUpdate;
	}

	public void setUpdate(boolean isUpdate) {
		this.isUpdate = isUpdate;
	}

    

}
