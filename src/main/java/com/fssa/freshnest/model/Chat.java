package com.fssa.freshnest.model;

import java.sql.Timestamp;
import java.util.Arrays;

/**
 * Represents a .
 *
 * @author SusikumarPitchaimuthu
 */

public class Chat {

	private String chatType;
	private String chatName;
	private int[] participantsId;
	private int chatId;
	private User user;
	private int senderId;
	private int messageId;
	private String chatMessage;
	private boolean isDelete;
	private boolean isUpdate;

	private Timestamp timestamp;

	// Default constructor
	public Chat() {

	}

	// chat id and user id constructor
	public Chat(int chatId, int[] participantsId) {
		this.chatId = chatId;
		this.participantsId = participantsId;
	}

	// chat and sender id setting constructor
	public Chat(int chatId, int senderId, String chatMessage) {
		this.chatId = chatId;
		this.senderId = senderId;
		this.chatMessage = chatMessage;
	}

	// chat data type insert constructor
	public Chat(String chatType, String chatName) {
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

	// Getter for getting participants id
	public int[] getParticipantsId() {
		return participantsId;
	}

	public void setParticipantsId(int[] participantsId) {
		this.participantsId = participantsId;
	}

	public String getChatName() {
		return chatName;
	}

	public void setChatName(String chatName) {
		this.chatName = chatName;
	}

	public int getChatId() {
		return chatId;
	}

	public void setChatId(int chatId) {
		this.chatId = chatId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Chat{" + "chatType='" + chatType + '\'' + ", chatName='" + chatName + '\'' + ", participantsId="
				+ Arrays.toString(participantsId) + ", chatId=" + chatId + ", userId=" + user + ", senderId=" + senderId
				+ ", messageId=" + messageId + ", chatMessage='" + chatMessage + '\'' + ", isDelete=" + isDelete
				+ ", isUpdate=" + isUpdate + ", timestamp=" + timestamp + '}';
	}
}
