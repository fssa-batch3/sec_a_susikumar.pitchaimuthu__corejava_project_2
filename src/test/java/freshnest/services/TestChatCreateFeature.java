package freshnest.services;

import java.time.LocalDate;
import java.time.LocalTime;

import freshnest.model.Chat;

public class TestChatCreateFeature {
	public static void main(String[] args) { 

		String chatText = "Hello baby..";
		LocalDate currentDate = LocalDate.now();
		LocalTime currentTime = LocalTime.now();

		Chat chat = new Chat(chatText, currentDate, currentTime, true, false, false, 9, 10);

		ChatService chatService = new ChatService();

		try {
			chatService.createChat(chat);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
 