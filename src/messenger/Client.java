package messenger;

public class Client {

	private String name;
	private Message message;
	private static int uniqueCounter = 0;
	private int currentId;
	private Server connectedTo;
	
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
		connectedTo = s;
		++uniqueCounter;
		currentId = uniqueCounter;
	}
	
	public Client(String n, Message m, Server s)
	{
		name = n;
		connectedTo = s;
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

	public Server getConnectedTo() {
		return connectedTo;
	}

	public void setConnectedTo(Server connectedTo) {
		this.connectedTo = connectedTo;
	}

	public String getName() {
		return name;
	}

	public int getCurrentId() {
		return currentId;
	}
	
	
}
