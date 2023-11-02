package com.fssa.freshnest.model;

import java.sql.Timestamp;

/**
 * Represents a chat entity that encapsulates various properties and actions
 * related to a chat conversation. This class provides constructors and methods
 * to manage different aspects of a chat.
 *
 * @author SusikumarPitchaimuth
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
	private String groupTheme;
	private String profileImage;
	private String username;
	private int userId;
	private String userTheme;
	private String groupImage;
	private boolean isAdmin;
	private int unReadMessageCount;
	private String lastMessageSender;
	private boolean doesEveryoneReadMessage;
	

	public String getLastMessageSender() {
		return lastMessageSender;
	}

	public void setLastMessageSender(String lastMessageSender) {
		this.lastMessageSender = lastMessageSender;
	}

	public boolean isDoesEveryoneReadMessage() {
		return doesEveryoneReadMessage;
	}

	public void setDoesEveryoneReadMessage(boolean doesEveryoneReadMessage) {
		this.doesEveryoneReadMessage = doesEveryoneReadMessage;
	}

	public int getUnReadMessageCount() {
		return unReadMessageCount;
	}

	public void setUnReadMessageCount(int unReadMessageCount) {
		this.unReadMessageCount = unReadMessageCount;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getGroupImage() {
		return groupImage;
	}

	public void setGroupImage(String groupImage) {
		this.groupImage = groupImage;
	}

	public String getGroupTheme() {
		return groupTheme;
	}

	public void setGroupTheme(String groupTheme) {
		this.groupTheme = groupTheme;
	}

	public String getUserTheme() {
		return userTheme;
	}

	public void setUserTheme(String userTheme) {
		this.userTheme = userTheme;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	// Default constructor

	/**
	 * Default constructor for creating a Chat object with no initial values.
	 */
	public Chat() {
		// Default constructor
	}

	/**
	 * Constructor for creating a Chat object with specified chat ID and participant
	 * IDs.
	 *
	 * @param chatId         The unique identifier for the chat.
	 * @param participantsId An array of participant IDs in the chat.
	 */
	public Chat(int chatId, int[] participantsId) {
		this.chatId = chatId;
		this.participantsId = participantsId;
	}

	/**
	 * Constructor for creating a Chat object with specified chat ID, sender ID, and
	 * chat message.
	 *
	 * @param chatId      The unique identifier for the chat.
	 * @param senderId    The ID of the sender of the message.
	 * @param chatMessage The content of the chat message.
	 */
	public Chat(int chatId, int senderId, String chatMessage) {
		this.chatId = chatId;
		this.senderId = senderId;
		this.chatMessage = chatMessage;
	}

	/**
	 * Constructor for creating a Chat object with specified chat message, chat ID,
	 * and message ID.
	 *
	 * @param chatText  The content of the chat message.
	 * @param chatId    The unique identifier for the chat.
	 * @param messageId The ID of the chat message.
	 */
	public Chat(String chatText, int chatId, int messageId) {
		this.chatMessage = chatText;
		this.chatId = chatId;
		this.messageId = messageId;
	}

	public Chat(String chatMessage) {
		this.chatMessage = chatMessage;
	}

	/**
	 * Getter for retrieving the chat type.
	 *
	 * @return The type of the chat.
	 */
	public String getChatType() {
		return chatType;
	}

	/**
	 * Setter for setting the chat type.
	 *
	 * @param chatType The type of the chat.
	 */
	public void setChatType(String chatType) {
		this.chatType = chatType;
	}

	/**
	 * Getter for retrieving the array of participant IDs.
	 *
	 * @return An array of participant IDs in the chat.
	 */
	public int[] getParticipantsId() {
		return participantsId;
	}

	/**
	 * Setter for setting the array of participant IDs.
	 *
	 * @param participantsId An array of participant IDs in the chat.
	 */
	public void setParticipantsId(int[] participantsId) {
		this.participantsId = participantsId;
	}

	/**
	 * Getter for retrieving the chat name.
	 *
	 * @return The name of the chat.
	 */
	public String getChatName() {
		return chatName;
	}

	/**
	 * Setter for setting the chat name.
	 *
	 * @param chatName The name of the chat.
	 */
	public void setChatName(String chatName) {
		this.chatName = chatName;
	}

	/**
	 * Getter for retrieving the chat ID.
	 *
	 * @return The unique identifier for the chat.
	 */
	public int getChatId() {
		return chatId;
	}

	/**
	 * Setter for setting the chat ID.
	 *
	 * @param chatId The unique identifier for the chat.
	 */
	public void setChatId(int chatId) {
		this.chatId = chatId;
	}

	/**
	 * Getter for retrieving the associated user.
	 *
	 * @return The user associated with the chat.
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Setter for setting the associated user.
	 *
	 * @param user The user associated with the chat.
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Getter for retrieving the sender ID.
	 *
	 * @return The ID of the sender of the message.
	 */
	public int getSenderId() {
		return senderId;
	}

	/**
	 * Setter for setting the sender ID.
	 *
	 * @param senderId The ID of the sender of the message.
	 */
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	/**
	 * Getter for retrieving the message ID.
	 *
	 * @return The ID of the chat message.
	 */
	public int getMessageId() {
		return messageId;
	}

	/**
	 * Setter for setting the message ID.
	 *
	 * @param messageId The ID of the chat message.
	 */
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	/**
	 * Getter for retrieving the chat message content.
	 *
	 * @return The content of the chat message.
	 */
	public String getChatMessage() {
		return chatMessage;
	}

	/**
	 * Setter for setting the chat message content.
	 *
	 * @param chatMessage The content of the chat message.
	 */
	public void setChatMessage(String chatMessage) {
		this.chatMessage = chatMessage;
	}

	/**
	 * Getter for retrieving the deletion status.
	 *
	 * @return True if the chat or message is marked for deletion, otherwise false.
	 */

	public boolean getDelete() {
		return isDelete;
	}

	/**
	 * Setter for setting the deletion status.
	 *
	 * @param isDelete True to mark the chat or message for deletion, otherwise
	 *                 false.
	 */
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	/**
	 * Getter for retrieving the update status.
	 *
	 * @return True if the chat or message has been updated, otherwise false.
	 */
	public boolean getUpdate() {
		return isUpdate;
	}

	/**
	 * Setter for setting the update status.
	 *
	 * @param isUpdate True to indicate that the chat or message has been updated,
	 *                 otherwise false.
	 */
	public void setUpdate(boolean isUpdate) {
		this.isUpdate = isUpdate;
	}

	/**
	 * Getter for retrieving the timestamp of the chat event.
	 *
	 * @return The timestamp of the chat event.
	 */
	public Timestamp getTimestamp() {
		return timestamp;
	}

	/**
	 * Setter for setting the timestamp of the chat event.
	 *
	 * @param timestamp The timestamp of the chat event.
	 */
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Chat: [" + ", chatName=" + username + "groupImage=" + profileImage + " ]";
	}

}
