package messenger;

public class MyClient {

	private String name;
	private Message message;
	private static int uniqueCounter = 0;
	private int currentId;
	private Server server;

	public MyClient(String n, Server s) {
		name = n;
		server = s;
		++uniqueCounter;
		currentId = uniqueCounter;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server s) {
		this.server = s;
	}

	public String getName() {
		return name;
	}

	public int getCurrentId() {
		return currentId;
	}

	public boolean sendMessageViaServer() {
		return server.receiveMessageQueue(message);
	}

	public void receiveMessageFromServer(Message m) {
		System.out.println("Message received from " + m.getSenderAsString());
	}

	public boolean sendTopicViaServer(TopicType type, int timeOut) {
		Topic topic;
		if (message.getRecipient() == null) {
			topic = new Topic(message, type, timeOut, server);
			return server.receiveTopic(topic);
		} else
			return false;
	}

	public void readTopic(TopicType type) {
		Topic t = server.searchTopicViaType(type);
		System.out.println(name + ": Topic read!");
	}

}
