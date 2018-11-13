package messenger;

public class MainClass {

	public static void main(String[] args) {
		Server server = new Server(20, 150);
	
		MyClient ale = new MyClient("Alexandra", server);
		MyClient eme = new MyClient("Emese", server);
		MyClient adi = new MyClient("Adrian", server);
		MyClient iulia = new MyClient("Iulia", server);
	
		Message message1 =  new Message("Hello there!", eme, ale);
		Message message2 = new Message("Hi, Ale!", ale, eme);
		
		Message message3 = new Message("The Lord of the Rings is awesome!", null, iulia);
		Message message4 = new Message("Steelheart is a good book!", null, adi);
				
	
		ale.setMessage(message1);
		eme.setMessage(message2);
		iulia.setMessage(message3);
		adi.setMessage(message4);
		
		ServerTimeOutTask timeOut = new ServerTimeOutTask(server);
		timeOut.start();
		
		//first scenario when two clients send message at the same time
		ClientQueueMessaging Messaging_first = new ClientQueueMessaging("FIRST MESSAGING", ale, server);
		Messaging_first.start();
		ClientQueueMessaging Messaging_second = new ClientQueueMessaging("SECOND MESSAGING", eme, server);
		Messaging_second.start();
		
		//topic sending - in parallel
		SendTopicToServer topic_send_first = new SendTopicToServer("FIRST TOPIC SEND", iulia, TopicType.MOVIES);
		topic_send_first.start();
		SendTopicToServer topic_send_second = new SendTopicToServer("SECOND TOPIC SEND", iulia, TopicType.MOVIES);
		topic_send_second.start();
		SendTopicToServer topic_send_third = new SendTopicToServer("THIRD TOPIC SEND", adi, TopicType.LITERATURE);
		topic_send_third.start();
		
		SearchForTopic topic_search_first = new SearchForTopic("FIRST TOPIC SEARCH", ale, TopicType.MOVIES);
		topic_search_first.start();
		
				
	}
			
}
