package freshnest.services;

import java.time.LocalDate;
import java.time.LocalTime;

import freshnest.model.Chat;

public class TestChatUpdateFeature {
	
	  public static void main(String[] args) {

	        String chatText = "Hello chellam..";
	        LocalDate currentDate = LocalDate.now();
	        LocalTime currentTime = LocalTime.now();
	        int chatId = 2;

	        Chat chat = new Chat(chatText, currentDate, currentTime, false, false, true, 9, 10, chatId);

	        ChatService chatService = new ChatService();

	        try {
	            chatService.updateChat(chat);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }


}
