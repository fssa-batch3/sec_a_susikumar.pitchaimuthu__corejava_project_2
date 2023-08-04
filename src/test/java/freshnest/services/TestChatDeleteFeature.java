package freshnest.services;

import freshnest.model.Chat;

public class TestChatDeleteFeature {

	public static void main(String[] args) {

		int chatId = 2;

		Chat chat = new Chat(true, chatId);
 
		ChatService chatService = new ChatService();

		try {
			chatService.deleteChat(chat);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}

}
