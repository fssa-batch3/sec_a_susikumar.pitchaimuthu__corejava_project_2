package freshnest.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Chat {

	private String chat;
	private LocalDate chat_date;
	private LocalTime chat_time;
	private boolean isRead;
	private boolean isDelete;
	private boolean isUpdate;
	private int chat_senderId;
	private int chat_receiverId;
	private int chatId;

	public Chat(String chat, LocalDate chat_date, LocalTime chat_time, boolean isRead, boolean isDelete,
			boolean isUpdate, int chat_senderId, int chat_receiverId) {
		this.chat = chat;
		this.chat_date = chat_date;
		this.chat_time = chat_time;
		this.isRead = isRead;
		this.chat_senderId = chat_senderId;
		this.chat_receiverId = chat_receiverId;
		this.isDelete = isDelete;
		this.isUpdate = isUpdate;
	}

	public Chat(String chat, LocalDate chat_date, LocalTime chat_time, boolean isRead, boolean isDelete,
		 boolean isUpdate,	int chat_senderId, int chat_receiverId, int chatId) {
		this.chat = chat;
		this.chat_date = chat_date;
		this.chat_time = chat_time;
		this.isRead = isRead;
		this.chat_senderId = chat_senderId;
		this.chat_receiverId = chat_receiverId;
		this.isDelete = isDelete;
		this.chatId = chatId;
		this.isUpdate = isUpdate;

	}

	
	public Chat(boolean isDelete, int chatId) {
		this.isDelete = isDelete;
		this.chatId = chatId;
	}

	public int get_chatId() {
		return chatId;
	}

	public void setChatId(int chatId) {
		this.chatId = chatId;
	}

	public String getChat() {
		return chat;
	}

	public void setChat(String chat) {
		this.chat = chat;
	}

	public LocalDate getChat_date() {
		return chat_date;
	}

	public void setChat_date(LocalDate chat_date) {
		this.chat_date = chat_date;
	}

	public LocalTime getChat_time() {
		return chat_time;
	}

	public void setChat_time(LocalTime chat_time) {
		this.chat_time = chat_time;
	}

	public boolean get_isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

	public boolean get_isUpdate() {
		return isUpdate;
	}

	public void isUpdate(boolean isUpdate) {
		this.isUpdate = isUpdate;
	}

	public boolean get_isDelete() {
		return isDelete;
	}

	public void isDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public int getChat_senderId() {
		return chat_senderId;
	}

	public void setChat_senderId(int chat_senderId) {
		this.chat_senderId = chat_senderId;
	}

	public int getChat_receiverId() {
		return chat_receiverId;
	}

	public void setChat_receiverId(int chat_receiverId) {
		this.chat_receiverId = chat_receiverId;
	}

}
