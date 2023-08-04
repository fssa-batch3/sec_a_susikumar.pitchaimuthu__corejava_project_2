package freshnest.services;

import java.time.LocalDate;
import java.time.LocalTime;

import freshnest.model.Chat;

public class TestChatReadFeature {
	  public static void main(String[] args) {

	        String chatText = "Hello chellam..";
	        LocalDate currentDate = LocalDate.now();
	        LocalTime currentTime = LocalTime.now();
	        int chatId = 2;

	        Chat chat = new Chat(chatText, currentDate, currentTime, true, false, true, 9, 10, chatId);

	        ChatService chatService = new ChatService();

	        try {
	            chatService.readChat(chat);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}
