package com.fssa.freshnest.model;

public class Chat {

	private String chatType;
	private int chatName;
	private int chat_id;
	private int user_id;
	private int sender_id;
	private String chat_message;
	private boolean is_delete;
	private boolean is_update;

	// chat id and user id constructor
	public Chat(int chat_id, int user_id) {
		this.chat_id = chat_id;
		this.user_id = user_id;
	}

	// chat and sender id setting constructor
	public Chat(int chat_id, int sender_id, String chat_message) {
		this.chat_id = chat_id;
		this.sender_id = sender_id;
		this.chat_message = chat_message;
	}
	// chat data type insert constructor
	public Chat(String chatType, int chatName) {
		this.chatType = chatType;
		this.chatName = chatName;
	}

	// chat read constructor
	public Chat(int chat_id) {
		this.chat_id = chat_id;
	}

	// Delete chat constructor
	public Chat(boolean is_delete, int chat_id) {
		this.is_delete = is_delete;
		this.chat_id = chat_id;
	}

	public String getChatType() {
		return chatType;
	}

	public void setChatType(String chatType) {
		this.chatType = chatType;
	}

	public boolean get_isDelete() {
		return is_delete;
	}

	public void setIs_delete(boolean is_delete) {
		this.is_delete = is_delete;
	}

	public boolean get_isUpdate() {
		return is_update;
	}

	public void setIs_update(boolean is_update) {
		this.is_update = is_update;
	}

	public Chat() {

	}

	public int getChatName() {
		return chatName;
	}

	public void setChatName(int chatName) {
		this.chatName = chatName;
	}

	public int getChat_id() {
		return chat_id;
	}

	public void setChat_id(int chat_id) {
		this.chat_id = chat_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getSender_id() {
		return sender_id;
	}

	public void setSender_id(int sender_id) {
		this.sender_id = sender_id;
	}

	public String getChat_message() {
		return chat_message;
	}

	public void setChat_message(String chat_message) {
		this.chat_message = chat_message;
	}

}
