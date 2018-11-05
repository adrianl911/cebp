package messenger;

public class Client {

	private String name;
	private Message message;
	private static int uniqueCounter = 0;
	private int currentId;
	private Server server;
	
	public Client(String n)
	{
		name = n;
		++uniqueCounter;
		currentId = uniqueCounter;
	}
	
	public Client(String n,Message m)
	{
		name = n;
		message = m;
		++uniqueCounter;
		currentId = uniqueCounter;
	}
	
	public Client(String n, Server s)
	{
		name = n;
		server = s;
		++uniqueCounter;
		currentId = uniqueCounter;
	}
	
	public Client(String n, Message m, Server s)
	{
		name = n;
		server = s;
		message = m;
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
	
	public boolean sendMessageViaServer()
	{
		return server.recieveMessageQueue(message);
	}
	
	public void recieveMessageFromServer(Message m)
	{
		System.out.println("Message revied from" + m.getSenderAsString());
	}
	
	public boolean sendTopicViaServer(TopicType type, int timeOut)
	{
		Topic topic;
		if(message.getRecipient() == null)
		{
			topic = new Topic(message, type, timeOut, server);
			return server.recieveTopic(topic);
		}
		else return false;
	}
	
	public void readTopic(TopicType type)
	{
		Topic t = server.searchTopicViaType(type);
		System.out.println(name + " :Topic read!");
	}
	
	
	
}
